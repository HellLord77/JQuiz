/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jquiz.database.columns;

/**
 *
 * @author ratul
 */
public record AllColumn() implements Column {

    private final static AllColumn allColumn = new AllColumn();

    public static AllColumn get() {
        return allColumn;
    }

    @Override
    public String toSql(String table) {
        return "*";  // TODO "`%s`.*".formatted(table);
    }
}
