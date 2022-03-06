package com.sda.jdbc;

import java.sql.*;

//Driver musi dostarczyć implementacje
//java.sql.Driver
// Connection
// Statement
// ResultSet

//Dobrze wiedzić ale nie jest to raczej używane
//Statement -
//execute() CREAT Table, ALTER Table - zwraca Boolean
//executeQuerry() - Select,DROP,
//executeUpdate(0 - insert,update,delete

//affected -

//CRUD  - podstawowe operacje na danych !!!!!!
//Create, INSERT  executeUpdate()
//READ, SELECT    executeQuery()
//UPDATE, Update  executeUpdate()
//DELETE DELETE   executeUpdate()


import static com.sda.jdbc.Configuration.*;

public class Main1Preparation {

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
