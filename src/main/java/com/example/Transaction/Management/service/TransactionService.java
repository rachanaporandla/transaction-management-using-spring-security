package com.example.Transaction.Management.service;

import com.example.Transaction.Management.dto.TransactionRequestDTO;
import com.example.Transaction.Management.dto.TransactionResponseDTO;
import com.example.Transaction.Management.entity.Transaction;
import java.util.List;

public interface TransactionService {
    Transaction create(TransactionRequestDTO dto);
    Transaction patchUpdate(Long id, TransactionResponseDTO dto);
    Transaction searchByTransactionId(String transactionId);
    List<Transaction> getAll();
    void delete(Long id);
    long countByDate(String date);
}
