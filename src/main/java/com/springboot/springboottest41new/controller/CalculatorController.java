package com.springboot.springboottest41new.controller;

import com.springboot.springboottest41new.DAO.InsertData;
import com.springboot.springboottest41new.entity.VariableParametersOperation;
import com.springboot.springboottest41new.service.TotalPriceService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Data
public class CalculatorController {

    private final TotalPriceService totalPriceService;

    public CalculatorController(TotalPriceService totalPriceService) {
        this.totalPriceService = totalPriceService;

    }

    @GetMapping("/calc")
    public String calc(Model model) {
        model.addAttribute("operation", new VariableParametersOperation());


        InsertData insertData = new InsertData();
        insertData.insertRecord(100.50, 200.75, 300.25);
        model.addAttribute("insertData", insertData);

        return "calc";
    }

    @PostMapping("/calc")
    public String calcPost(VariableParametersOperation variableParametersOperation, Model model) {
        double result = totalPriceService.getTotalPrice(variableParametersOperation);
        model.addAttribute("operation", variableParametersOperation);
        model.addAttribute("result", result);

        InsertData insertData = new InsertData();
        insertData.insertRecord(
                variableParametersOperation.getOneQuadratMetterFoilPrice(),
                variableParametersOperation.getOneOttiskPrice(),
                variableParametersOperation.getMontageWorkPrice());

        return "calc";
    }
}