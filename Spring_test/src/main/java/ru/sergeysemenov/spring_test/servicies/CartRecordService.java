package ru.sergeysemenov.spring_test.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sergeysemenov.spring_test.enteties.CartRecord;

import ru.sergeysemenov.spring_test.repositories.CartRecordRepository;


@Service
public class CartRecordService {
     private CartRecordRepository recordRepository;


    @Autowired
    public void setRecordRepository(CartRecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public boolean checkIfExistByProductIdAndUserId(Long productId, Long userId){
        return recordRepository.existsCartRecordByProductIdAndUserId(productId, userId);
    }

    public CartRecord getRecordByProductIdAndUserId(Long productId, Long userId){
        return recordRepository.getCartRecordByProductIdAndUserId(productId, userId);
    }

    public CartRecord saveOrUpdateRecord(CartRecord record){
        return recordRepository.save(record);
    }

    public long countRecordByUserId(Long userId){
        return recordRepository.countCartRecordByUserId(userId);
    }

    @Transactional
    public void deleteRecordByProductIdAndUserId(Long productId, Long userId){
        recordRepository.deleteCartRecordByProductIdAndUserId(productId, userId);
    }

}


