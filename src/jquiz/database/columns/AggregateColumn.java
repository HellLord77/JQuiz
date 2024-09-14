/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jquiz.database.columns;

/**
 *
 * @author ratul
 */
public record AggregateColumn(String symbol, boolean isDistinct, Column column) implements Column {

    public static AggregateColumn count(String columnName) {
        return count(SimpleColumn.get(columnName));
    }

    public static AggregateColumn count(Column column) {
        return new AggregateColumn("COUNT", false, column);
    }

    public static AggregateColumn sum(String columnName) {
        return sum(SimpleColumn.get(columnName));
    }

    public static AggregateColumn sum(Column column) {
        return new AggregateColumn("SUM", false, column);
    }

    public static AggregateColumn avg(String columnName) {
        return avg(SimpleColumn.get(columnName));
    }

    public static AggregateColumn avg(Column column) {
        return new AggregateColumn("AVG", false, column);
    }

    public static AggregateColumn min(String columnName) {
        return min(SimpleColumn.get(columnName));
    }

    public static AggregateColumn min(Column column) {
        return new AggregateColumn("MIN", false, column);
    }

    public static AggregateColumn max(String columnName) {
        return max(SimpleColumn.get(columnName));
    }

    public static AggregateColumn max(Column column) {
        return new AggregateColumn("MAX", false, column);
    }

    @Override
    public String toSql(String table) {
        return "%s(%s %s)".formatted(symbol, isDistinct ? "DISTINCT" : "ALL", column.toSql(table));
    }
}
