package com.sis.config;

import com.sis.data.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgreSQLJDBC {

    public static void main(String args[]) throws SQLException {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/shs",
                            DbParams.db_user, DbParams.db_pass);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        User emin = new User();
        emin.getUserByPassword("emin", "emin", c);
        //stmt = c.createStatement();
        //String sql = "INSERT INTO user_table (user_name, login_name, user_type, user_status, user_email, user_pass) "
        //        + "VALUES ('Emin ÞÝT', 'emin', 1, 1, 'eminsit@gmail.com', 'emin' );";
        //stmt.executeUpdate(sql);

        c.close();

        System.out.println("Opened database successfully");
    }

}
