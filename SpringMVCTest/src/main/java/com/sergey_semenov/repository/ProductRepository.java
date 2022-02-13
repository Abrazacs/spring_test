package com.sergey_semenov.repository;

import com.sergey_semenov.entity.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> productList;

    public ProductRepository(){
        productList = new ArrayList<>();
    }

    public Product getProductById(long id){
        for (Product p:productList) {
            if(p.getId()==id)return p;
        }
        return new Product(id,"We don't have such product",0);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void addProduct(Product product){
        productList.add(product);
    }
}
