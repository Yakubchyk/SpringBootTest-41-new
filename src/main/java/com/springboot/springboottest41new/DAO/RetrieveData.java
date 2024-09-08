package com.springboot.springboottest41new.DAO;

import com.springboot.springboottest41new.entity.VariableParametersOperation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetrieveData {

    public VariableParametersOperation getLatestRecord() {
        PostgresConnection postgresConnection = new PostgresConnection();
        String SQL_SELECT = "SELECT foilprice, priceottisk, pricepriladka FROM rechnung LIMIT 1";

        VariableParametersOperation variableParametersOperation = new VariableParametersOperation();

        try (Connection conn = new PostgresConnection().connect();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                variableParametersOperation.setOneQuadratMetterFoilPrice(resultSet.getDouble("foilprice"));
                variableParametersOperation.setOneOttiskPrice(resultSet.getDouble("priceottisk"));
                variableParametersOperation.setMontageWorkPrice(resultSet.getDouble("pricepriladka"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return variableParametersOperation;
    }
}