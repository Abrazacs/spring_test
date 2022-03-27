package ru.sergeysemenov.spring_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sergeysemenov.spring_test.servicies.AuthoritiesService;

import javax.sql.DataSource;
import java.util.List;

@Controller
public class AdminController {

    private AuthoritiesService authoritiesService;

    @Autowired
    public void setAuthoritiesService(AuthoritiesService authoritiesService) {
        this.authoritiesService = authoritiesService;
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping("/admin")
    public String adminPanel(Model model){
        List<String> roles = authoritiesService.getAllRoles();
        model.addAttribute("roles", roles);
        return "admin";
    }

}
