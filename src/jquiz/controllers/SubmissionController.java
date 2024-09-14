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
import jquiz.models.AttemptModel;
import jquiz.models.QuizModel;
import jquiz.database.Engine;
import jquiz.database.Joiner;
import jquiz.database.columns.SimpleColumn;
import jquiz.database.operators.ComparisonOperator;
import jquiz.database.operators.LogicalOperator;
import jquiz.models.SubmissionModel;

/**
 *
 * @author ratul
 */
public class SubmissionController extends Controller<SubmissionModel> {

    public SubmissionController(Engine engine) {
        super(engine);
    }

    @Override
    protected String table() {
        return "submissions";
    }

    @Override
    protected SubmissionModel model(Map<String, Object> result) {
        return new SubmissionModel(
                (int) result.get("id"),
                engine.attemptController.read((int) result.get("attempt_id")),
                (int) result.get("answer_count"),
                (Timestamp) result.get("created_at"),
                (Timestamp) result.get("updated_at"));
    }

    public SubmissionModel create(
            AttemptModel attempt,
            int answerCount) {
        return create(Map.of(
                "attempt_id", attempt.id(),
                "answer_count", answerCount));
    }

    public long count(AttemptModel attempt) {
        return count(new CountBuilder()
                .operator(ComparisonOperator.eq("attempt_id", attempt.id())));
    }

    public boolean exists(AttemptModel attempt) {
        return exists(new ExistsBuilder()
                .operator(ComparisonOperator.eq("attempt_id", attempt.id())));
    }

    public boolean exists(UserModel user, QuizModel quiz) {
        return exists(Joiner.get("attempts", LogicalOperator.get(
                ComparisonOperator.eq("attempt_id", new SimpleColumn("attempts", "id")))),
                LogicalOperator.get(ComparisonOperator.get("attempts",
                        Map.of("user_id", user.id(), "quiz_id", quiz.id()))));
    }

    public List<SubmissionModel> filter(AttemptModel attempt) {
        return filter(new FilterBuilder()
                .operator(ComparisonOperator.eq("attempt_id", attempt.id())));
    }
}
