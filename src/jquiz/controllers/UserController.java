/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jquiz.controllers;

import java.util.Map;
import jquiz.models.UserModel;
import jquiz.enums.RoleEnum;
import jquiz.database.Engine;
import jquiz.Util;
import jquiz.database.operators.ComparisonOperator;
import jquiz.database.operators.LogicalOperator;
import java.sql.Timestamp;
import jquiz.controllers.builders.ExistsBuilder;
import jquiz.controllers.builders.ReadBuilder;

/**
 *
 * @author ratul
 */
public class UserController extends Controller<UserModel> {

    public UserController(Engine engine) {
        super(engine);
    }

    @Override
    protected String table() {
        return "users";
    }

    @Override
    protected UserModel model(Map<String, Object> result) {
        return new UserModel(
                (int) result.get("id"),
                RoleEnum.values()[Integer.parseInt((String) result.get("role"))],
                (String) result.get("name"),
                (String) result.get("email"),
                (String) result.get("password"),
                (Timestamp) result.get("created_at"),
                (Timestamp) result.get("updated_at"));
    }

    public UserModel create(RoleEnum role, String name, String email, String password) {
        return create(Map.of(
                "role", String.valueOf(role.ordinal()),
                "name", name,
                "email", email,
                "password", Util.sha1(password)));
    }

    public UserModel read(String email, String password) {
        return read(new ReadBuilder()
                .operator(LogicalOperator.get(ComparisonOperator.get(Map.of("email", email, "password", Util.sha1(password))))));
    }

    public UserModel update(UserModel user, String password) {
        return update(user, Map.of("password", Util.sha1(password)));
    }

    public boolean exists(String email) {
        return exists(new ExistsBuilder()
                .operator(ComparisonOperator.eq("email", email)));
    }

    public UserModel readName(String name, String email) {  // TODO
        return read(new ReadBuilder()
                .operator(LogicalOperator.get(ComparisonOperator.get(Map.of("name", name, "email", email)))));
    }

    public boolean existsName(String name) {  // TODO
        return exists(new ExistsBuilder()
                .operator(ComparisonOperator.eq("name", name)));
    }
}
