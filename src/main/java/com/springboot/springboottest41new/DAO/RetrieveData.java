package com.springboot.springboottest41new.DAO;

import jdk.dynalink.Operation;

public class RetrieveData {

    public Operation getLatestRecord() {
        PostgresConnection postgresConnection = new PostgresConnection();
        String SQL_SELECT = "SELECT foilprice, priceottisk, pricepriladka FROM rechnung LIMIT 1";



        return null;
    }

}
