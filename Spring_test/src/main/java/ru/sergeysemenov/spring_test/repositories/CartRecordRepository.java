package ru.sergeysemenov.spring_test.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sergeysemenov.spring_test.enteties.CartRecord;

import java.util.List;

@Repository
public interface CartRecordRepository extends CrudRepository<CartRecord, Long> {

    boolean existsCartRecordByProductIdAndUserId(Long productId, Long userId);

    CartRecord getCartRecordByProductId(Long productId);

    CartRecord getCartRecordByProductIdAndUserId(Long productId, Long userId);

    Long countCartRecordByUserId(Long userId);

    void deleteCartRecordByProductIdAndUserId(Long productId, Long userId);

}
