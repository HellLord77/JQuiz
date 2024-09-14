/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jquiz.controllers;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import jquiz.controllers.builders.CountBuilder;
import jquiz.controllers.builders.FilterBuilder;
import jquiz.database.operators.ComparisonOperator;
import jquiz.database.Engine;
import jquiz.enums.AnswerEnum;
import jquiz.models.QuestionModel;
import jquiz.models.QuizModel;

/**
 *
 * @author ratul
 */
public class QuestionController extends Controller<QuestionModel> {

    public QuestionController(Engine engine) {
        super(engine);
    }

    @Override
    protected String table() {
        return "questions";
    }

    @Override
    protected QuestionModel model(Map<String, Object> result) {
        return new QuestionModel(
                (int) result.get("id"),
                engine.quizController.read((int) result.get("quiz_id")),
                (String) result.get("text"),
                (String) result.get("hint"),
                (String) result.get("option_0"),
                (String) result.get("option_1"),
                (String) result.get("option_2"),
                (String) result.get("option_3"),
                AnswerEnum.values()[Integer.parseInt((String) result.get("answer"))],
                (Timestamp) result.get("created_at"),
                (Timestamp) result.get("updated_at"));
    }

    public QuestionModel create(
            QuizModel quiz,
            String text,
            String hint,
            String option0,
            String option1,
            String option2,
            String option3,
            AnswerEnum answer) {
        return create(Map.of(
                "quiz_id", quiz.id(),
                "text", text,
                "hint", hint,
                "option_0", option0,
                "option_1", option1,
                "option_2", option2,
                "option_3", option3,
                "answer", String.valueOf(answer.ordinal())));
    }

    public long count(QuizModel quiz) {
        return count(new CountBuilder()
                .operator(ComparisonOperator.eq("quiz_id", quiz.id())));
    }

    public List<QuestionModel> filter(QuizModel quiz) {
        return filter(new FilterBuilder()
                .operator(ComparisonOperator.eq("quiz_id", quiz.id())));
    }
}
