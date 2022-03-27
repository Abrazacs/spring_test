package ru.sergeysemenov.spring_test.repositories;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.sergeysemenov.spring_test.enteties.Product;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product,Long> {
    Product findOneById(Long id);
}
