package ru.sergeysemenov.spring_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sergeysemenov.spring_test.enteties.CartRecord;
import ru.sergeysemenov.spring_test.enteties.Product;
import ru.sergeysemenov.spring_test.enteties.User;
import ru.sergeysemenov.spring_test.servicies.CartRecordService;
import ru.sergeysemenov.spring_test.servicies.ProductService;
import ru.sergeysemenov.spring_test.servicies.UserService;


import java.security.Principal;


@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    private UserService userService;
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
    public String showProducts(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("productList", productService.getProducts());
        model.addAttribute("linesQty",recordService.countRecordByUserId(user.getId()));
        model.addAttribute("cartValue", productService.calculateCartPrice(user));
        return "products";
    }


    @GetMapping("/{id}")
    public String showProduct(@PathVariable("id") long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "product-info";
    }

    @PostMapping("")
    public String createOrUpdateCartRecord(@RequestParam("productId") Long productId,
                                   @RequestParam("quantity") int quantity, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        if (recordService.checkIfExistByProductIdAndUserId(productId, user.getId())) {
            if(quantity == 0){
                recordService.deleteRecordByProductIdAndUserId(productId, user.getId());
            }
            else {
                CartRecord record = recordService.getRecordByProductIdAndUserId(productId, user.getId());
                record.setProductQty(quantity);
                recordService.saveOrUpdateRecord(record);
            }
            return "redirect:/cart";
        } else {
            CartRecord record = new CartRecord();
            record.setProduct(productService.getProductById(productId));
            record.setUserId(user.getId());
            record.setProductQty(quantity);
            recordService.saveOrUpdateRecord(record);
        }
        return "redirect:/products";
    }

}
