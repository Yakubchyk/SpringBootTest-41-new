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

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

