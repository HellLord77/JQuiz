/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jquiz.database.columns;

import java.util.Arrays;

/**
 *
 * @author ratul
 */
public record FunctionColumn(String symbol, Object[] values) implements Column {

    public static FunctionColumn row_number() {
        return get("ROW_NUMBER");
    }

    public static FunctionColumn rank() {
        return get("RANK");
    }

    public static FunctionColumn dense_rank() {
        return get("DENSE_RANK");
    }

    public static FunctionColumn get(String symbol) {
        return new FunctionColumn(symbol, new Object[0]);
    }

    @Override
    public String toSql(String table) {
        return "%s(%s)".formatted(symbol, String.join(", ", Arrays.stream(
                values).map((Object value) -> value instanceof Column valueColumn
                ? valueColumn.toSql(table) : String.valueOf(value)).toList()));
    }
}
