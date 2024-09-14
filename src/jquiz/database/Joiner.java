/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jquiz.database;

import java.util.Iterator;
import java.util.Arrays;
import jquiz.database.operators.Operator;

/**
 *
 * @author ratul
 */
public record Joiner(String table, Operator operator) implements Iterable<Object> {

    public static Joiner[] get(String table, Operator... operators) {
        // TODO
        Joiner[] joiners = new Joiner[operators.length];
        return Arrays.stream(operators).map((Operator operator)
                -> new Joiner(table, operator)).toList().toArray(joiners);
    }

    public String toSql(String table) {
        return "JOIN `%s` ON %s".formatted(this.table, operator.toSql(table));
    }

    @Override
    public Iterator<Object> iterator() {
        return operator.iterator();
    }
}
