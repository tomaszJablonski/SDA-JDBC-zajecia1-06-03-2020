package com.sda.jdbc;

import java.sql.*;

import static com.sda.jdbc.Configuration.*;

public class Main4StatementExercise {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, ROOT, PASSWORD);

            Statement initialStatement = connection.createStatement();
            initialStatement.execute("" +
                    "CREATE TABLE IF NOT EXISTS user1(" +
                    "id BIGINT NOT NULL AUTO_INCREMENT," +
                    "username VARCHAR (50) UNIQUE," +
                    "password VARCHAR (50)," +
                    "PRIMARY KEY (id))");

            initialStatement.close();

            Statement insertStatement = connection.createStatement();
            insertStatement.executeUpdate("" +
                    "INSERT INTO user1 (username,password) VALUES " +
                    "('jan','sdfsdf')," +
                    "('Roman','sdf4334')," +
                    "('Harry','435dfg')");

            initialStatement.close();

            Statement queryStatement = connection.createStatement();
            ResultSet selectUsernameFromUser1 = queryStatement.executeQuery("SELECT username FROM user1");

            while (selectUsernameFromUser1.next()) {
                String name = selectUsernameFromUser1.getString("username");
                System.out.println(name);
            }

            selectUsernameFromUser1.close();
            queryStatement.close();

        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
    }
}
