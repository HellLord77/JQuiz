/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jquiz.database.operators;

import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author ratul
 */
public record EmptyOperator() implements Operator {

    private final static EmptyOperator emptyOperator = new EmptyOperator();

    public static EmptyOperator get() {
        return emptyOperator;
    }

    @Override
    public String toSql(String table) {
        return "";
    }

    @Override
    public Iterator<Object> iterator() {
        return Collections.emptyIterator();
    }
}
