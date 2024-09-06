package com.springboot.springboottest41new.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {

    public void insertRecord(double foilPrice, double priceOttisk, double pricePriladka) {
        String SQL_INSERT = "INSERT INTO rechnung(foilprice, priceottisk, pricepriladka) VALUES (?, ?, ?)";

        try (Connection conn = new PostgresConnection().connect();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {

            preparedStatement.setDouble(1, foilPrice);
            preparedStatement.setDouble(2, priceOttisk);
            preparedStatement.setDouble(3, pricePriladka);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Добавлено в БД: " + rowsAffected);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        InsertData insertData = new InsertData();

        insertData.insertRecord(100.50, 200.75, 300.25);
    }
}