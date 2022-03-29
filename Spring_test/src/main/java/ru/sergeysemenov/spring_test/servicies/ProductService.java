package ru.sergeysemenov.spring_test.servicies;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sergeysemenov.spring_test.enteties.CartRecord;
import ru.sergeysemenov.spring_test.enteties.Product;
import ru.sergeysemenov.spring_test.enteties.User;
import ru.sergeysemenov.spring_test.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private CategoryService categoryService;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public ProductService(){
    }

    public List<Product> getProducts(){
        return (List<Product>) productRepository.findAll();
    }

    public Product getProductById(long id){
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    public void deleteById(long id){
        productRepository.findById(id);
    }

    public Product saveOrUpdate(Product product){
        return productRepository.save(product);
    }

    public double calculateCartPrice(User user) {
        double totalPrice = 0.0;
        List<CartRecord> records = user.getCartRecordList();
        if (!records.isEmpty()) {
            for (CartRecord record : records) {
                totalPrice = totalPrice + (record.getProduct().getPrice() * record.getProductQty());
            }
        }
        return totalPrice;
    }

}
