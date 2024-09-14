/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jquiz.database.operators;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Optional;
import java.util.stream.Stream;
import jquiz.Util;

/**
 *
 * @author ratul
 */
public record LogicalOperator(Operator operator1, String symbol, Operator operator2) implements Operator {

    public static LogicalOperator and(Operator operator1, Operator operator2) {
        return new LogicalOperator(operator1, "AND", operator2);
    }

    public static LogicalOperator or(Operator operator1, Operator operator2) {
        return new LogicalOperator(operator1, "OR", operator2);
    }

    public static Operator get(Operator... operators) {
        Optional<Operator> optionalOperator = Arrays.stream(operators).reduce((
                Operator operator1, Operator operator2) -> and(operator1, operator2));
        return optionalOperator.isPresent() ? optionalOperator.get() : EmptyOperator.get();
    }

    @Override
    public String toSql(String table) {
        return "(%s %s %s)".formatted(operator1.toSql(table), symbol, operator2.toSql(table));
    }

    @Override
    public Iterator<Object> iterator() {
        return Stream.concat(Util.stream(operator1), Util.stream(operator2)).iterator();
    }
}
