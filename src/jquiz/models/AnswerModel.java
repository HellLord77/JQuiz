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
public record AnswerModel(
        int id,
        SubmissionModel submission,
        QuestionModel question,
        AnswerEnum answer,
        Timestamp createdAt,
        Timestamp updatedAt) implements Model {

}
