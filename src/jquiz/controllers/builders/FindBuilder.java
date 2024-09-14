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
public class FindBuilder {

    private Sorter[] sorters = new Sorter[0];
    private Joiner[] joiners = new Joiner[0];
    private Operator operator = EmptyOperator.get();
    private long offset = 0;

    public Sorter[] sorters() {
        return sorters;
    }

    public FindBuilder sorters(Sorter[] sorters) {
        this.sorters = sorters;
        return this;
    }

    public Joiner[] joiners() {
        return joiners;
    }

    public FindBuilder joiners(Joiner[] joiners) {
        this.joiners = joiners;
        return this;
    }

    public Operator operator() {
        return operator;
    }

    public FindBuilder operator(Operator operator) {
        this.operator = operator;
        return this;
    }

    public long offset() {
        return offset;
    }

    public FindBuilder offset(long offset) {
        this.offset = offset;
        return this;
    }
}
