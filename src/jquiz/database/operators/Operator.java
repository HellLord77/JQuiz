/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jquiz.database.operators;

/**
 *
 * @author ratul
 */
public interface Operator extends Iterable<Object> {

    String toSql(String table);
}
