/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jquiz.database.columns;

/**
 *
 * @author ratul
 */
public record SimpleColumn(String table, String name) implements Column {

    public static SimpleColumn get(String name) {
        return new SimpleColumn(null, name);
    }

    @Override
    public String toSql(String table) {
        if (this.table != null) {
            table = this.table;
        }
        return "`%s`.`%s`".formatted(table, name);
    }
}
