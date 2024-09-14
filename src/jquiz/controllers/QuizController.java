/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jquiz.controllers;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import jquiz.models.UserModel;
import jquiz.models.QuizModel;
import jquiz.Const;
import jquiz.controllers.builders.CountBuilder;
import jquiz.controllers.builders.FilterBuilder;
import jquiz.database.operators.ComparisonOperator;
import jquiz.database.Engine;
import jquiz.database.Joiner;
import jquiz.database.Sorter;
import jquiz.database.columns.SimpleColumn;
import jquiz.database.operators.Operator;

/**
 *
 * @author ratul
 */
public class QuizController extends Controller<QuizModel> {

    public QuizController(Engine engine) {
        super(engine);
    }

    @Override
    protected String table() {
        return "quizzes";
    }

    @Override
    protected QuizModel model(Map<String, Object> result) {
        return new QuizModel(
                (int) result.get("id"),
                engine.userController.read((int) result.get("user_id")),
                (String) result.get("title"),
                (String) result.get("description"),
                (Time) result.get("duration"),
                (Time) result.get("pause_duration"),
                (int) result.get("question_count"),
                (Timestamp) result.get("created_at"),
                (Timestamp) result.get("updated_at"));
    }

    public QuizModel create(
            UserModel user,
            String title,
            String description,
            Time duration,
            Time pauseDuration,
            int questionCount) {
        return create(Map.of(
                "user_id", user.id(),
                "title", title,
                "description", description,
                "duration", duration,
                "pause_duration", pauseDuration,
                "question_count", questionCount));
    }

    public long count(UserModel user) {
        return count(new CountBuilder()
                .operator(ComparisonOperator.eq("user_id", user.id())));
    }

    public long countPage(Operator operator) {  // TODO
        long count = count(new CountBuilder()
                .operator(operator));
        if (count == 0) {
            return 0;
        }
        return count / Const.QUIZ_PER_PAGE + 1;
    }

    public List<QuizModel> filterPage(Operator operator, Sorter[] sorters, long page) {  // TODO
        return filter(new FilterBuilder()
                .joiners(Joiner.get("users", ComparisonOperator.eq("user_id", new SimpleColumn("users", "id"))))
                .operator(operator)
                .sorters(sorters)
                .limit(Const.QUIZ_PER_PAGE)
                .offset((page - 1) * Const.QUIZ_PER_PAGE));
    }
}
