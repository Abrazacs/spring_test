package com.sergey_semenov;

import com.sergey_semenov.entity.Product;
import com.sergey_semenov.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@org.springframework.stereotype.Controller
public class MainController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String hello(Model model, @RequestParam String name) {
        model.addAttribute("name", name);
        return "index";
    }

    @RequestMapping("/showForm")
    public String showSimpleForm(Model uiModel) {
        Product product = new Product();
        uiModel.addAttribute("product", product);
        return "product-form";
    }

    @RequestMapping("/addProduct")
    public String addProductToRepository(@ModelAttribute("product") Product product, Model model){
        List<Product> productList = productService.getAllProducts();
        if(productList.contains(product)){
            model.addAttribute("result","such product already exists");
        }else {
        productService.addProduct(product);
        model.addAttribute("result", "product has been added successfully");}
        return "result";
    }

    @RequestMapping("/showProducts")
    public String showAllProducts(Model model){
        String productList = productService.getProducts();
        model.addAttribute("productList", productList);
        return "show-products";
    }

}
