/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sis.beans;

import com.sis.config.DataBaseConnection;
import com.sis.data.User;
import java.sql.Connection;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author emin
 */
@SessionScoped
@ManagedBean
public class loginBean {

    private String loginName;
    private String password;

    private User user;
    private boolean rememberMe;
    private boolean isConnect;
    Connection connection;

    public loginBean() {
        DataBaseConnection dbc = new DataBaseConnection();
        if (connection == null) {
            dbc.connect();
            connection = dbc.connection;
            isConnect = dbc.isConnect;
        }
    }

    public void checkUserExists() {

    }

    public void isExists() throws SQLException {
        System.out.println(loginName + "---" + password);
        user = new User();
        user.getUserByPassword(loginName, password, connection);
        if (user.theOne != null) {
            System.out.println(user.theOne.getName());
        }
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isIsConnect() {
        return isConnect;
    }

    public void setIsConnect(boolean isConnect) {
        this.isConnect = isConnect;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

}
