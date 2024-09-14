/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jquiz.controllers.builders;

import jquiz.database.Joiner;
import jquiz.database.Sorter;
import jquiz.database.operators.EmptyOperator;
import jquiz.database.operators.Operator;

/**
 *
 * @author ratul
 */
public class ReadBuilder {

    private Joiner[] joiners = new Joiner[0];
    private Operator operator = EmptyOperator.get();
    private Sorter[] sorters = new Sorter[0];
    private long offset = 0;

    public Joiner[] joiners() {
        return joiners;
    }

    public ReadBuilder joiners(Joiner[] joiners) {
        this.joiners = joiners;
        return this;
    }

    public Operator operator() {
        return operator;
    }

    public ReadBuilder operator(Operator operator) {
        this.operator = operator;
        return this;
    }

    public Sorter[] sorters() {
        return sorters;
    }

    public ReadBuilder sorters(Sorter[] sorters) {
        this.sorters = sorters;
        return this;
    }

    public long offset() {
        return offset;
    }

    public ReadBuilder offset(long offset) {
        this.offset = offset;
        return this;
    }
}
