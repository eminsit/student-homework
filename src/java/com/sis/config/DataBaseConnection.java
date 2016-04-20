/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sis.config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author emin
 */
public class DataBaseConnection {

    public Connection connection;
    public boolean isConnect = false;

    public void connect() {
        connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/" + DbParams.db_name,
                            DbParams.db_user, DbParams.db_pass);

            isConnect = true;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
