package com.springboot.springboottest41new.service;

import com.springboot.springboottest41new.entity.VariableParametersOperation;
import org.springframework.stereotype.Service;

@Service
public class TotalPriceService {

    private static final double COEFFICIENT_METER = 10000;
    private static final double COEFFICIENT_NDS = 1.25;
    private static final double COEFFICIENT_WORK = 1.05;


    public double getTotalPrice(VariableParametersOperation variableParametersOperation) {
        double widthSM = variableParametersOperation.getWidthSM();
        double lengthSM = variableParametersOperation.getLengthSM();
        int quantity = variableParametersOperation.getQuantity();
        double montageWorkPrice = variableParametersOperation.getMontageWorkPrice();
        double oneOttiskPrice = variableParametersOperation.getOneOttiskPrice();
        double oneQuadratMetterFoilPrice = variableParametersOperation.getOneQuadratMetterFoilPrice();

        double totalPrice;
        double quadratMetter; // промежуточный параметр площади в метрах квадратных. Учавствует в расчетах.
        double getTotalFoilExpense;
        double getTotalWorkPrice;

        int min = 50;

        if ((widthSM * lengthSM) <= min) {
            quadratMetter = min / COEFFICIENT_METER;
        } else {
            quadratMetter = (widthSM * lengthSM) / COEFFICIENT_METER;
        }

        getTotalFoilExpense = (((quantity * quadratMetter) * COEFFICIENT_WORK) * oneQuadratMetterFoilPrice) * COEFFICIENT_NDS;

        getTotalWorkPrice = (montageWorkPrice + oneOttiskPrice * quantity) * COEFFICIENT_WORK;

        totalPrice = getTotalWorkPrice + getTotalFoilExpense;

        return totalPrice;
    }
}


