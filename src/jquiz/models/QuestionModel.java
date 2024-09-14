/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jquiz.models;

import java.sql.Timestamp;
import jquiz.enums.AnswerEnum;

/**
 *
 * @author ratul
 */
public record QuestionModel(
        int id,
        QuizModel quiz,
        String text,
        String hint,
        String option0,
        String option1,
        String option2,
        String option3,
        AnswerEnum answer,
        Timestamp createdAt,
        Timestamp updatedAt) implements Model {

}
