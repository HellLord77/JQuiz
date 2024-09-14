/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jquiz.database.operators;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import jquiz.database.columns.Column;
import jquiz.database.columns.SimpleColumn;

/**
 *
 * @author ratul
 */
public record ComparisonOperator(Column column, String symbol, Object value) implements Operator {

    public static ComparisonOperator lt(String columnName, Object value) {
        return lt(SimpleColumn.get(columnName), value);
    }

    public static ComparisonOperator lt(Column column, Object value) {
        return new ComparisonOperator(column, "<", value);
    }

    public static ComparisonOperator le(String columnName, Object value) {
        return le(SimpleColumn.get(columnName), value);
    }

    public static ComparisonOperator le(Column column, Object value) {
        return new ComparisonOperator(column, "<=", value);
    }

    public static ComparisonOperator eq(String columnName, Object value) {
        return eq(SimpleColumn.get(columnName), value);
    }

    public static ComparisonOperator eq(Column column, Object value) {
        return new ComparisonOperator(column, "=", value);
    }

    public static ComparisonOperator ne(String columnName, Object value) {
        return ne(SimpleColumn.get(columnName), value);
    }

    public static ComparisonOperator ne(Column column, Object value) {
        return new ComparisonOperator(column, "!=", value);
    }

    public static ComparisonOperator gt(String columnName, Object value) {
        return gt(SimpleColumn.get(columnName), value);
    }

    public static ComparisonOperator gt(Column column, Object value) {
        return new ComparisonOperator(column, ">", value);
    }

    public static ComparisonOperator ge(String columnName, Object value) {
        return ge(SimpleColumn.get(columnName), value);
    }

    public static ComparisonOperator ge(Column column, Object value) {
        return new ComparisonOperator(column, ">=", value);
    }

    public static ComparisonOperator like(String columnName, Object value) {
        return like(SimpleColumn.get(columnName), value);
    }

    public static ComparisonOperator like(Column column, Object value) {
        return new ComparisonOperator(column, "LIKE", value);
    }

    public static ComparisonOperator[] get(Map<String, Object> equals) {
        return get(null, equals);
    }

    public static ComparisonOperator[] get(String table, Map<String, Object> equals) {
        ComparisonOperator[] comparisonOperators = new ComparisonOperator[equals.size()];
        return equals.entrySet().stream().map((Entry<String, Object> entry) -> eq(
                new SimpleColumn(table, entry.getKey()), entry.getValue())).toList().toArray(comparisonOperators);
    }

    @Override
    public String toSql(String table) {
        return value instanceof Column valueColumn ? "%s %s %s".formatted(column.toSql(table), symbol,
                valueColumn.toSql(table)) : "%s %s ?".formatted(column.toSql(table), symbol);
    }

    @Override
    public Iterator<Object> iterator() {
        return value instanceof Column ? Collections.emptyIterator()
                : Collections.singleton(value).iterator();
    }
}
