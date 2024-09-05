package com.springboot.springboottest41new.controller;

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
        return "calc";
    }

    @PostMapping("/calc")
    public String calcPost(VariableParametersOperation variableParametersOperation, Model model) {
        double result = totalPriceService.getTotalPrice(variableParametersOperation);
        model.addAttribute("operation", variableParametersOperation);
        model.addAttribute("result", result);
        return "calc";
    }
}