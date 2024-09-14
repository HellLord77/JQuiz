package jquiz.database;

import jquiz.Const;
import jquiz.Util;
import jquiz.database.operators.Operator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Collections;
import jquiz.controllers.UserController;
import jquiz.controllers.QuizController;
import jquiz.controllers.QuestionController;
import jquiz.controllers.SubmissionController;
import jquiz.controllers.AnswerController;
import jquiz.controllers.AttemptController;
import java.util.Map;
import java.util.Arrays;
import java.math.BigInteger;
import java.util.Optional;
import java.util.stream.Stream;
import jquiz.database.columns.AllColumn;
import jquiz.database.columns.Column;
import com.mysql.cj.jdbc.Driver;
import jquiz.database.columns.AggregateColumn;
import jquiz.database.columns.FunctionColumn;

public class Engine {

    public final UserController userController;
    public final QuizController quizController;
    public final QuestionController questionController;
    public final AttemptController attemptController;
    public final SubmissionController submissionController;
    public final AnswerController answerController;

    private Connection connection;

    public Engine() {
        this(Const.DATABASE_URL);
    }

    public Engine(String url) {
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException exception) {
            System.err.println(exception);
            System.exit(1);
        }

        userController = new UserController(this);
        quizController = new QuizController(this);
        questionController = new QuestionController(this);
        attemptController = new AttemptController(this);
        submissionController = new SubmissionController(this);
        answerController = new AnswerController(this);
    }

    private String sortersToString(String table, Sorter[] sorters) {
        return String.join(", ", Arrays.stream(sorters).map(
                (Sorter sorter) -> sorter.toSql(table)).toList());
    }

    private void setArgs(PreparedStatement statement, Object... args) throws SQLException {
        for (int index = 0; index < args.length; ++index) {
            statement.setObject(index + 1, args[index]);
        }
    }

    private ArrayList<HashMap<String, Object>> getResults(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metadata = resultSet.getMetaData();
        String[] columns = new String[metadata.getColumnCount()];
        for (int index = 0; index < columns.length; ++index) {
            columns[index] = metadata.getColumnName(index + 1);
        }
        ArrayList<HashMap<String, Object>> results = new ArrayList<>();
        while (resultSet.next()) {
            HashMap<String, Object> result = new HashMap<>();
            for (String column : columns) {
                result.put(column, resultSet.getObject(column));
            }
            results.add(result);
        }
        return results;
    }

    private ArrayList<HashMap<String, Object>> executeQuery(String query, Object... args) {
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            setArgs(statement, args);
            System.out.println(statement);
            return getResults(statement.executeQuery());
        } catch (SQLException exception) {
            System.err.println(exception);
            return new ArrayList<>();
        }
    }

    private boolean executeUpdate(String query, Object... args) {
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            setArgs(statement, args);
            System.out.println(statement);
            return statement.executeUpdate() != 0;
        } catch (SQLException exception) {
            System.err.println(exception);
            return false;
        }
    }

    private int executeInsert(String query, Object... args) {
        try (PreparedStatement statement = connection.prepareStatement(
                query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            setArgs(statement, args);
            System.out.println(statement);
            if (statement.executeUpdate() != 0) {
                ArrayList<HashMap<String, Object>> keys = getResults(
                        statement.getGeneratedKeys());
                if (!keys.isEmpty()) {
                    return ((BigInteger) keys.get(0).getOrDefault(
                            "GENERATED_KEY", -1)).intValueExact();
                }
            }
        } catch (SQLException exception) {
            System.err.println(exception);
        }
        return -1;
    }

    private int[] executeInsertBatch(String query, Object[]... argLists) {  // TODO
        int[] inserted = new int[argLists.length];
        try (PreparedStatement statement = connection.prepareStatement(
                query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            for (Object[] args : argLists) {
                setArgs(statement, args);
                statement.addBatch();
            }
            System.out.println(statement);
            int totalCount = 0;
            for (int count : statement.executeBatch()) {
                if (count > 0) {
                    totalCount += count;
                }
            }
            if (totalCount == argLists.length) {
                ArrayList<HashMap<String, Object>> keys = getResults(
                        statement.getGeneratedKeys());
                for (int index = 0; index < argLists.length; ++index) {
                    inserted[index] = ((BigInteger) keys.get(index).getOrDefault(
                            "GENERATED_KEY", -1)).intValueExact();
                }
                return inserted;
            }
        } catch (SQLException exception) {
            System.err.println(exception);
        }
        Arrays.fill(argLists, -1);
        return inserted;
    }

    private ArrayList<HashMap<String, Object>> select(Column column, String table,
            Joiner[] joiners, Operator operator, Sorter[] sorters, long limit, long offset) {
        String query = "SELECT %s FROM `%s`".formatted(column.toSql(table), table);
        if (joiners.length != 0) {
            query += " %s".formatted(String.join(" ", Arrays.stream(joiners).map(
                    (Joiner joiner) -> joiner.toSql(table)).toList()));
        }
        String filter = operator.toSql(table);
        if (!filter.isBlank()) {
            query += " WHERE %s".formatted(filter);
        }
        if (sorters.length != 0) {
            query += " ORDER BY %s".formatted(sortersToString(table, sorters));
        }
        if (limit != 0) {
            query += " LIMIT %d".formatted(limit);
        }
        if (offset != 0) {
            query += " OFFSET %d".formatted(offset);
        }
        ArrayList<Object> args = new ArrayList<>();
        Optional<Stream<Object>> optionalJoinArgs = Arrays.stream(joiners).map((
                Joiner joiner) -> Util.stream(joiner)).reduce((Stream<Object> joiner1,
                Stream<Object> joiner2) -> Stream.concat(joiner1, joiner2));
        if (optionalJoinArgs.isPresent()) {
            args.addAll(optionalJoinArgs.get().toList());
        }
        args.addAll(Util.stream(operator).toList());
        return executeQuery(query, args.toArray());
    }

    public boolean update(String table, Map<String, Object> columns, Operator operator) {
        String query = "UPDATE `%s`".formatted(table);
        if (!columns.isEmpty()) {
            query += " SET %s".formatted(String.join(", ", columns.entrySet().stream().map(
                    (Entry<String, Object> entry) -> "`%s`.`%s` = ?".formatted(
                            table, entry.getKey(), entry.getValue())).toList()));
        }
        String filter = operator.toSql(table);
        if (!filter.isBlank()) {
            query += " WHERE %s".formatted(filter);
        }
        ArrayList<Object> args = new ArrayList<>();
        args.addAll(columns.values());
        args.addAll(Util.stream(operator).toList());
        return executeUpdate(query, args.toArray());
    }

    public int insert(String table, Map<String, Object> columns) {
        String query = "INSERT INTO `%s` (%s) VALUES (%s)".formatted(
                table, String.join(", ", columns.keySet().stream().map((String key) -> "`%s`".formatted(
                key)).toList()), String.join(", ", Collections.nCopies(columns.size(), "?")));
        return executeInsert(query, columns.values().toArray());
    }

    public ArrayList<HashMap<String, Object>> filter(String table, Joiner[] joiners,
            Operator operator, Sorter[] sorters, long limit, long offset) {
        return select(AllColumn.get(), table, joiners, operator, sorters, limit, offset);
    }

    public long aggregate(AggregateColumn aggregate, String table, Joiner[] joiners, Operator operator, long offset) {
        ArrayList<HashMap<String, Object>> results = select(aggregate,
                table, joiners, operator, new Sorter[0], 0, offset);
        if (results.isEmpty()) {
            return -1;
        }
        return (long) results.get(0).getOrDefault(aggregate.toSql(table), -1);
    }

    public long function(FunctionColumn function, String table, Joiner[] joiners,
            Operator operator, Sorter[] sorters, long limit, long offset) {
        ArrayList<HashMap<String, Object>> results = select(function,
                table, joiners, operator, sorters, limit, offset);
        if (results.isEmpty()) {
            return -1;
        }
        return (long) results.get(0).getOrDefault(function.toSql(table), -1);
    }
}
