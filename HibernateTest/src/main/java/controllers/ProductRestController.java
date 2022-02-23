package controllers;

import entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import servicies.ProductService;

import java.util.List;

@RestController
public class ProductRestController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService){
        this.productService = productService;
    }

    @RequestMapping(path = "/products/{id}", method= RequestMethod.GET)
    public Product getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }

    @RequestMapping(path = "/products",  method=RequestMethod.GET)
    public List<Product> getAllProducts(){
        return productService.getProducts();
    }

    @RequestMapping(path = "/products/delete/{id}", method= RequestMethod.GET)
    public void deleteProductById(@PathVariable("id") Long id){
        productService.deleteById(id);
    }

    @RequestMapping(path = "/products", method = RequestMethod.POST)
    public void addProduct(Product product){
        productService.addProduct(product);
    }
}
