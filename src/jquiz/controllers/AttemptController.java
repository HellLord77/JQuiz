/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jquiz.controllers;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import jquiz.controllers.builders.ExistsBuilder;
import jquiz.controllers.builders.CountBuilder;
import jquiz.controllers.builders.FilterBuilder;
import jquiz.models.UserModel;
import jquiz.models.QuizModel;
import jquiz.database.Engine;
import jquiz.database.operators.ComparisonOperator;
import jquiz.database.operators.LogicalOperator;
import jquiz.models.AttemptModel;

/**
 *
 * @author ratul
 */
public class AttemptController extends Controller<AttemptModel> {

    public AttemptController(Engine engine) {
        super(engine);
    }

    @Override
    protected String table() {
        return "attempts";
    }

    @Override
    protected AttemptModel model(Map<String, Object> result) {
        return new AttemptModel(
                (int) result.get("id"),
                engine.userController.read((int) result.get("user_id")),
                engine.quizController.read((int) result.get("quiz_id")),
                (Timestamp) result.get("created_at"),
                (Timestamp) result.get("updated_at"));
    }

    public AttemptModel create(
            UserModel user,
            QuizModel quiz) {
        return create(Map.of(
                "user_id", user.id(),
                "quiz_id", quiz.id()));
    }

    public long count(UserModel user) {
        return count(new CountBuilder()
                .operator(ComparisonOperator.eq("user_id", user.id())));
    }

    public long count(QuizModel quiz) {
        return count(new CountBuilder()
                .operator(ComparisonOperator.eq("quiz_id", quiz.id())));
    }

    public boolean exists(UserModel user, QuizModel quiz) {
        return exists(new ExistsBuilder()
                .operator(LogicalOperator.get(ComparisonOperator.get(Map.of("user_id", user.id(), "quiz_id", quiz.id())))));
    }

    public List<AttemptModel> filter(UserModel user) {
        return filter(new FilterBuilder()
                .operator(ComparisonOperator.eq("user_id", user.id())));
    }

    public List< AttemptModel> filter(QuizModel quiz) {
        return filter(new FilterBuilder()
                .operator(ComparisonOperator.eq("quiz_id", quiz.id())));
    }

    public List<AttemptModel> filter(UserModel user, QuizModel quiz) {
        return filter(new FilterBuilder()
                .operator(LogicalOperator.get(ComparisonOperator.get(Map.of("user_id", user.id(), "quiz_id", quiz.id())))));
    }
}
