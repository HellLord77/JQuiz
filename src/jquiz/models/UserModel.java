/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jquiz.models;

import java.sql.Timestamp;
import jquiz.enums.RoleEnum;

/**
 *
 * @author ratul
 */
public record UserModel(
        int id,
        RoleEnum role,
        String name,
        String email,
        String password,
        Timestamp createdAt,
        Timestamp updatedAt) implements Model {

}
