package com.example.Transaction.Management.repo;

import com.example.Transaction.Management.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {

    Transaction findByTransactionId(String transactionId);
    long countByDate(String date);
}
