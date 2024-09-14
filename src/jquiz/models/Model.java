/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jquiz.models;

import java.sql.Timestamp;

/**
 *
 * @author ratul
 */
public interface Model {

    int id();

    Timestamp createdAt();

    Timestamp updatedAt();
}
