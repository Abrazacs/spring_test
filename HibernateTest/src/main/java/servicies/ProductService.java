package servicies;

import entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository){
        this.productRepository = productRepository;
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

    public void addProduct(Product product){
        productRepository.save(product);
    }

    public void deleteById(long id){
        productRepository.findById(id);
    }

}
