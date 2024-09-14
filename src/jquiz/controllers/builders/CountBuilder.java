/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jquiz.controllers.builders;

import jquiz.database.Joiner;
import jquiz.database.operators.EmptyOperator;
import jquiz.database.operators.Operator;

/**
 *
 * @author ratul
 */
public class CountBuilder {

    private Joiner[] joiners = new Joiner[0];
    private Operator operator = EmptyOperator.get();
    private long offset = 0;

    public Joiner[] joiners() {
        return joiners;
    }

    public CountBuilder joiners(Joiner[] joiners) {
        this.joiners = joiners;
        return this;
    }

    public Operator operator() {
        return operator;
    }

    public CountBuilder operator(Operator operator) {
        this.operator = operator;
        return this;
    }

    public long offset() {
        return offset;
    }

    public CountBuilder offset(long offset) {
        this.offset = offset;
        return this;
    }
}
