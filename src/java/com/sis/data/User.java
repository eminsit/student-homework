/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sis.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList; 

/**
 *
 * @author emin
 */
public class User {

    private int id;
    private String name;
    private String loginName;
    private String email;
    private String statusStr;
    private String typeStr;
    private int status;
    private int type;
    private String password;
    private Statement statement = null;
    private ArrayList<User> users;
    public User theOne = null;
    
    /**
     * 
     * @param name login_name of user
     * @param pass password of user
     * @param c sqlConnection
     * @throws SQLException 
     * It is for login step
     */
    public void getUserByPassword(String name, String pass, Connection c) throws SQLException {
        statement = c.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM user_table WHERE login_name = '" + name + "' and user_pass = '" + pass + "';");
    
        this.setUserLÝst(rs);
        if (users.size() == 0) {
            System.out.println("User Bulunamadý");
        } 
        statement.close();
    }
    
    /**
     * 
     * @param id user_id
     * @param connection
     * @throws SQLException 
     * Get user by id
     */
    public void getUserById(int id, Connection connection) throws SQLException {
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM user_table WHERE id = " + id + ";");

        this.setUserLÝst(resultSet);
        if (users.size() == 0) {
            System.out.println("User Bulunamadý");
        } 
        statement.close();
    }
    
    /**
     * 
     * @param connection
     * @throws SQLException 
     */
    public void getAllUser(Connection connection) throws SQLException {
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM user_table;");

        this.setUserLÝst(resultSet);
        if (users.size() == 0) {
            System.out.println("User Bulunamadý");
        } 
        statement.close();
    }
    
    /**
     * 
     * @param resultSet
     * @throws SQLException 
     * 
     * It set global UserList with given sql result.
     */
    private void setUserLÝst(ResultSet resultSet) throws SQLException {
        users = new ArrayList<User>();
        User u = new User();
        while (resultSet.next()) {
            u = null;
            u.setId(resultSet.getInt("id"));
            u.setStatus(resultSet.getInt("user_status"));
            u.setType(resultSet.getInt("user_type"));
            u.setName(resultSet.getString("user_name"));
            u.setLoginName(resultSet.getString("login_name"));
            u.setEmail(resultSet.getString("user_email"));
            users.add(u);
        }
        if (users.size() == 1) {
            theOne  = u;
        }
    }
    
    /**
     * 
     * @param user
     * @param connection
     * @throws SQLException 
     */
    public void createUser(User user, Connection connection) throws SQLException {
        statement = connection.createStatement();
        String sql = "INSERT INTO user_table "
                + "("
                + "user_name, "
                + "login_name, "
                + "user_type, "
                + "user_status, "
                + "user_email, "
                + "user_pass) "
                + "VALUES ("
                + "'" + user.getName() + "', "
                + "'" + user.getLoginName() + "', "
                + user.getType() +", "
                + user.getStatus() +", "
                + "'" + user.getEmail() + "', "
                + "'" + user.getPassword() + "'"
                + ");";  
        statement.executeUpdate(sql);
        statement.close();
    }
    
    public void updateUser(User user, Connection connection) throws SQLException {
        statement = connection.createStatement();
        String sql = "UPDATE user_table set"
                + "user_name = '" + user.getName() + "', "
                + "login_name'" + user.getLoginName() + "', "
                + "user_type = " + user.getType() + ", "
                + "user_status = " + user.getStatus() + ", "
                + "user_email = '" + user.getEmail() + "', "
                + "user_pass '" + user.getEmail() + "' "
                + "WHERE"
                + "id = " + user.getId()
                +";";  
        statement.executeUpdate(sql);
        statement.close();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public String getTypeStr() {
        return typeStr;
    }

    public void setTypeStr(String typeStr) {
        this.typeStr = typeStr;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
    
    

}
