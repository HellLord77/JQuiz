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
public class FilterBuilder {

    private Joiner[] joiners = new Joiner[0];
    private Operator operator = EmptyOperator.get();
    private Sorter[] sorters = new Sorter[0];
    private long limit = 0;
    private long offset = 0;

    public Joiner[] joiners() {
        return joiners;
    }

    public FilterBuilder joiners(Joiner[] joiners) {
        this.joiners = joiners;
        return this;
    }

    public Operator operator() {
        return operator;
    }

    public FilterBuilder operator(Operator operator) {
        this.operator = operator;
        return this;
    }

    public Sorter[] sorters() {
        return sorters;
    }

    public FilterBuilder sorters(Sorter[] sorters) {
        this.sorters = sorters;
        return this;
    }

    public long limit() {
        return limit;
    }

    public FilterBuilder limit(long limit) {
        this.limit = limit;
        return this;
    }

    public long offset() {
        return offset;
    }

    public FilterBuilder offset(long offset) {
        this.offset = offset;
        return this;
    }
}
