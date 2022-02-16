package com.sergey_semenov.service;

import com.sergey_semenov.entity.Product;
import com.sergey_semenov.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(long id){
        return productRepository.getProductById(id);
    }

    public String getProducts(){
        List<Product> productList = productRepository.getProductList();
        if(productList.isEmpty()) return "repository is empty";
        StringBuilder sb = new StringBuilder();
        for (Product p: productList) {
            sb.append(p);
            sb.append("\n");
        } return sb.toString();
    }

    public List<Product> getAllProducts(){
        return productRepository.getProductList();
    }

    public void addProduct(Product p){
        productRepository.addProduct(p);
    }

}
