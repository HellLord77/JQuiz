/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jquiz.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jquiz.controllers.builders.ExistsBuilder;
import jquiz.controllers.builders.CountBuilder;
import jquiz.controllers.builders.FilterBuilder;
import jquiz.controllers.builders.FindBuilder;
import jquiz.controllers.builders.ReadBuilder;
import jquiz.database.operators.ComparisonOperator;
import jquiz.database.Engine;
import jquiz.database.Joiner;
import jquiz.database.Sorter;
import jquiz.database.columns.AggregateColumn;
import jquiz.database.columns.AllColumn;
import jquiz.database.columns.FunctionColumn;
import jquiz.database.operators.Operator;
import jquiz.models.Model;

/**
 *
 * @author ratul
 * @param <T>
 */
public abstract class Controller<T extends Model> {

    protected final Engine engine;

    Controller(Engine engine) {
        this.engine = engine;
    }

    abstract protected String table();

    abstract protected T model(Map<String, Object> result);

    public T create(Map<String, Object> columns) {
        int id = engine.insert(table(), columns);
        if (id == -1) {
            return null;
        }
        return read(id);
    }

    public T read(int id) {
        return read(new ReadBuilder()
                .operator(ComparisonOperator.eq("id", id)));
    }

    public T read(ReadBuilder readBuilder) {
        return read(readBuilder.joiners(), readBuilder.operator(),
                readBuilder.sorters(), readBuilder.offset());
    }

    public T read(Joiner[] joiners, Operator operator, Sorter[] sorters, long offset) {
        List<T> models = filter(new FilterBuilder()
                .joiners(joiners)
                .operator(operator)
                .sorters(sorters)
                .limit(1)
                .offset(offset));
        if (models.isEmpty()) {
            return null;
        }
        return models.get(0);
    }

    public T update(T model, Map<String, Object> columns) {
        boolean update = engine.update(table(), columns, ComparisonOperator.eq("id", model.id()));
        if (!update) {
            return null;
        }
        return read(model.id());
    }

    public long count() {
        return count(new CountBuilder());
    }

    public long count(CountBuilder countBuilder) {
        return count(countBuilder.joiners(),
                countBuilder.operator(), countBuilder.offset());
    }

    public long count(Joiner[] joiners, Operator operator, long offset) {
        return engine.aggregate(AggregateColumn.count(
                AllColumn.get()), table(), joiners, operator, offset);
    }

    public long find(FindBuilder findBuilder) {
        return find(findBuilder.sorters(), findBuilder.joiners(),
                findBuilder.operator(), findBuilder.offset());
    }

    public long find(Sorter[] sorters, Joiner[] joiners, Operator operator, long offset) {
        long row_number = engine.function(FunctionColumn.row_number(),
                table(), joiners, operator, sorters, 0, offset);
        if (row_number == -1) {
            return -1;
        }
        return row_number - 1;
    }

    public boolean exists() {
        return exists(new ExistsBuilder());
    }

    public boolean exists(int id) {
        return exists(new ExistsBuilder()
                .operator(ComparisonOperator.eq("id", id)));
    }

    public boolean exists(ExistsBuilder existsBuilder) {
        return exists(existsBuilder.joiners(), existsBuilder.operator());
    }

    public boolean exists(Joiner[] joiners, Operator operator) {
        return count(new CountBuilder()
                .joiners(joiners)
                .operator(operator)) > 0;
    }

    public List<T> filter() {
        return filter(new FilterBuilder());
    }

    public List<T> filter(FilterBuilder filterBuilder) {
        return filter(filterBuilder.joiners(), filterBuilder.operator(),
                filterBuilder.sorters(), filterBuilder.limit(), filterBuilder.offset());
    }

    public List<T> filter(Joiner[] joiners, Operator operator, Sorter[] sorters, long limit, long offset) {
        ArrayList<HashMap<String, Object>> results = engine.filter(
                table(), joiners, operator, sorters, limit, offset);
        return results.stream().map((HashMap<String, Object> result) -> model(result)).toList();
    }
}
