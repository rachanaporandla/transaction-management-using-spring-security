package com.example.Transaction.Management.repo;

import com.example.Transaction.Management.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {

    @Query(value = "SELECT * FROM transactions WHERE transaction_id = ?1", nativeQuery = true)
    Transaction findByTransactionId(String transactionId);

    @Query(value = "SELECT COUNT(*) FROM transactions WHERE date = ?1", nativeQuery = true)
    long countByDate(String date);
}
