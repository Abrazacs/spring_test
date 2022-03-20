package ru.sergeysemenov.spring_test.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sergeysemenov.spring_test.enteties.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
