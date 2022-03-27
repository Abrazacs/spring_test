package ru.sergeysemenov.spring_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sergeysemenov.spring_test.enteties.Product;
import ru.sergeysemenov.spring_test.servicies.ProductService;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService){
        this.productService = productService;
    }

    @RequestMapping("/list")
    public String showProducts(Model model){
        List<Product> products = productService.getProducts();
        model.addAttribute("productList", products);
        return "products";
    }

}
