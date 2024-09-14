/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jquiz.controllers;

import java.util.Map;
import jquiz.models.SubmissionModel;
import jquiz.database.Engine;
import jquiz.models.AnswerModel;
import jquiz.enums.AnswerEnum;
import jquiz.models.QuestionModel;
import java.sql.Timestamp;

/**
 *
 * @author ratul
 */
public class AnswerController extends Controller<AnswerModel> {

    public AnswerController(Engine engine) {
        super(engine);
    }

    @Override
    protected String table() {
        return "answers";
    }

    @Override
    protected AnswerModel model(Map<String, Object> result) {
        return new AnswerModel(
                (int) result.get("id"),
                engine.submissionController.read((int) result.get("submission_id")),
                engine.questionController.read((int) result.get("question_id")),
                AnswerEnum.values()[Integer.parseInt((String) result.get("answer"))],
                (Timestamp) result.get("created_at"),
                (Timestamp) result.get("updated_at"));
    }

    public AnswerModel create(
            SubmissionModel submission,
            QuestionModel question,
            AnswerEnum answer) {
        return create(Map.of(
                "submission_id", submission.id(),
                "question_id", question.id(),
                "answer", String.valueOf(answer.ordinal())));
    }
}
