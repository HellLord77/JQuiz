/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jquiz.database;

import jquiz.database.columns.Column;
import jquiz.database.columns.SimpleColumn;

/**
 *
 * @author ratul
 */
public record Sorter(Column column, String symbol) {

    public static Sorter asc(String columnName) {
        return asc(SimpleColumn.get(columnName));
    }

    public static Sorter asc(Column column) {
        return new Sorter(column, "ASC");
    }

    public static Sorter desc(String columnName) {
        return desc(SimpleColumn.get(columnName));
    }

    public static Sorter desc(Column column) {
        return new Sorter(column, "DESC");
    }

    public static Sorter[] get(String[] columns) {
        return get(null, columns);
    }

    public static Sorter[] get(String table, String[] columns) {
        Sorter[] sorters = new Sorter[columns.length];
        for (int index = 0; index < columns.length; ++index) {
            sorters[index] = asc(new SimpleColumn(table, columns[index]));
        }
        return sorters;
    }

    public String toSql(String table) {
        return "%s %s".formatted(column.toSql(table), symbol);
    }
}
