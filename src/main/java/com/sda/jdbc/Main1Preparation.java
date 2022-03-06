package com.sda.jdbc;

import java.sql.*;

import static com.sda.jdbc.Configuration.*;

public class Main1Preparation {
    //public static final String URL = "jdbc:mysql://localhost:3306/jdbc_shema?serverTimezone=UTC";
    //public static final String ROOT = "root";
    //public static final String PASSWORD = "Tomasz7645499#";

    public static void main(String[] args) throws SQLException {
        //połączenie z bazą danych: url,login,hasło
        Connection connection = DriverManager.getConnection(URL, ROOT, PASSWORD);
        //żądanie dostepu do bazy danych
        Statement statement = connection.createStatement();
        //wyegzekwowanie dostępu do bazy danych, wpisujemy kwerende
        ResultSet resultSet = statement.executeQuery("SELECT * FROM animal");
        //design Iterator z metodą next
        while (resultSet.next()) {
            long id = resultSet.getLong(1);
            String name = resultSet.getString(2);
            int age = resultSet.getInt(3);
            //String format
            System.out.printf("Id: %s Name: %s Age: %s\n", id, name, age);
        }


        //używać close żeby usuwać z pamięci dane RAM
        resultSet.close();
        statement.close();
        connection.close();

    }
}
