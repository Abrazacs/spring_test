package ru.sergeysemenov.spring_test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;


@Controller
public class MainController {

    @RequestMapping("/")
    public String showMainPaige() {
        return "index";
    }
}
