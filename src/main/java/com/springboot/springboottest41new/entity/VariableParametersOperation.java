package com.springboot.springboottest41new.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VariableParametersOperation {

    private int quantity;

    private double oneOttiskPrice;
    private double montageWorkPrice;
    private double oneQuadratMetterFoilPrice;

    private double widthSM;
    private double lengthSM;

}
