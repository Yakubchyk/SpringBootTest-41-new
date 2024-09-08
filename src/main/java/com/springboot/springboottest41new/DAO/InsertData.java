package com.springboot.springboottest41new.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {

    public void upsertRecord(double foilPrice, double priceOttisk, double pricePriladka) {
        String SQL_UPSERT = "INSERT INTO rechnung(foilprice, priceottisk, pricepriladka) " +
                "VALUES (?, ?, ?) " +
                "ON CONFLICT (id) " +
                "DO UPDATE SET foilprice = EXCLUDED.foilprice, " +
                "priceottisk = EXCLUDED.priceottisk, " +
                "pricepriladka = EXCLUDED.pricepriladka";

        try (Connection conn = new PostgresConnection().connect();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPSERT)) {

            preparedStatement.setDouble(1, foilPrice);
            preparedStatement.setDouble(2, priceOttisk);
            preparedStatement.setDouble(3, pricePriladka);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Данные успешно добавлены или обновлены.");
            }

        } catch (SQLException e) {
            System.out.println("Ошибка при вставке или обновлении данных: " + e.getMessage());
        }
    }
}

