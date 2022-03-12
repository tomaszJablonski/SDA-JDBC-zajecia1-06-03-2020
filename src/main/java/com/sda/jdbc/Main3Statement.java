package com.sda.jdbc;

import java.sql.*;

/*
------RÓŻNICA MIĘDZY TRUNCATE A DELETE
Oba usuwają wiersz z tabeli – TRUNCATE wszystkie,
DELETE dowolnie wybrane przez użytkownika.
Główna i najważniejsza różnica to, że TRUNCATE
jest szybszy od DELETE, a zawdzięcza to temu, że
nie zapisuje każdej operacji usunięcia w logach.
Natomiast DELETE loguje wszystkie zmiany, przez co
jest wolniejszy.


 */

import static com.sda.jdbc.Configuration.*;

public class Main3Statement {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, ROOT, PASSWORD);

        Statement updateStatement = connection.createStatement();


        int amount = updateStatement.executeUpdate("UPDATE animal SET name='Jasio' WHERE id=2");
        updateStatement.close();

        Statement selectStatement = connection.createStatement();
        ResultSet resultSet = selectStatement.executeQuery("SELECT * FROM animal");

        //design Iterator z metodą next
        while (resultSet.next()) {
            long id = resultSet.getLong(1);
            String name = resultSet.getString(2);
            int age = resultSet.getInt(3);
            //String format
            System.out.printf("Id: %s Name: %s Age: %s\n", id, name, age);
        }
        resultSet.close();
        selectStatement.close();

        Statement executeStatement = connection.createStatement();
        boolean truncateTableAnimal = executeStatement.execute("TRUNCATE TABLE animal"); // CREATE TABLE,ALTER TABLE,TRUNCATE
        System.out.println("truncateTableAnimal = " + truncateTableAnimal);
        executeStatement.close();


        connection.close();


    }
}
