package controllers;

import entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import servicies.ProductService;

import javax.print.attribute.standard.Media;
import java.awt.*;
import java.util.List;

@RestController
public class ProductRestController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService){
        this.productService = productService;
    }

    @GetMapping(path = "/products/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }

    @GetMapping(path = "/products")
    public List<Product> getAllProducts(){
        return productService.getProducts();
    }

    @DeleteMapping(path = "/products/delete/{id}")
    public void deleteProductById(@PathVariable("id") Long id){
        productService.deleteById(id);
    }

    @PostMapping(path = "/products")
    public Product addProduct(@RequestBody Product product){
        return productService.saveOrUpdate(product);
    }
    @PutMapping(path = "/products", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Product updateProduct (@RequestBody Product product){
        return productService.saveOrUpdate(product);
    }
}
