package ru.sergeysemenov.spring_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.sergeysemenov.spring_test.enteties.User;
import ru.sergeysemenov.spring_test.servicies.UserService;

import java.security.Principal;


@Controller
public class MainController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String showMainPaige(Principal principal, Model model) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("userName",user.getUsername());
        model.addAttribute("email", user.getEmail());
        return "index";
    }
}
