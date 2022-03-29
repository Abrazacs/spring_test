package ru.sergeysemenov.spring_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sergeysemenov.spring_test.enteties.User;
import ru.sergeysemenov.spring_test.servicies.CartRecordService;
import ru.sergeysemenov.spring_test.servicies.ProductService;
import ru.sergeysemenov.spring_test.servicies.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/cart")
public class CartController {
    private UserService userService;
    private ProductService productService;
    private CartRecordService recordService;

    @Autowired
    public void setRecordService(CartRecordService recordService) {
        this.recordService = recordService;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("")
    public String showCart(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("recordsInCart", user.getCartRecordList());
        model.addAttribute("cartValue", productService.calculateCartPrice(user));
        return "cart";
    }

    @GetMapping("/edit/{recordId}&{qty}")
    public void editRecord(@PathVariable("recordId") Long recordId, @PathVariable("qty") int qty){

    }
}
