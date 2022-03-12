package com.sda.jdbc;

import java.sql.*;

import static com.sda.jdbc.Configuration.*;

public class Main5PrepareStatement {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, ROOT, PASSWORD);

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT age FROM animal WHERE name=?");
        preparedStatement.setString(1, "Benio");
        ResultSet resultSet1 = preparedStatement.executeQuery();
        System.out.println("resultSet1 = " + resultSet1);

        while (resultSet1.next()) {
            int age = resultSet1.getInt("age");
            System.out.println("Age : " + age);
        }

        resultSet1.close();
        preparedStatement.close();
        connection.close();
    }
}
