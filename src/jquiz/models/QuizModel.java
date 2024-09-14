/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jquiz.models;

import java.sql.Time;
import java.sql.Timestamp;

/**
 *
 * @author ratul
 */
public record QuizModel(
        int id,
        UserModel user,
        String title,
        String description,
        Time duration,
        Time pauseDuration,
        int questionCount,
        Timestamp createdAt,
        Timestamp updatedAt) implements Model {

}
