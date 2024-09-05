package com.springboot.springboottest41new.controller;


import com.springboot.springboottest41new.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/reg")
    public String reg(Model model) {
        model.addAttribute("user", new User());
        return "reg";
    }

    @PostMapping("/reg")
    public String reg(@ModelAttribute("user") User user) {
        System.out.println(user);
        return "reg";
    }
}

