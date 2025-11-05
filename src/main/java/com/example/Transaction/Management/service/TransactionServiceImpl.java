package com.example.Transaction.Management.service;

import com.example.Transaction.Management.dto.TransactionRequestDTO;
import com.example.Transaction.Management.dto.TransactionResponseDTO;
import com.example.Transaction.Management.entity.Transaction;
import com.example.Transaction.Management.repo.TransactionRepo;
import com.example.Transaction.Management.Util.TransactionIdGenerator;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepo repo;

    public TransactionServiceImpl(TransactionRepo repo) {
        this.repo = repo;
    }
    public Transaction create(TransactionRequestDTO dto) {
        String generatedId = TransactionIdGenerator.getInstance().generateTransactionId();
        Transaction transaction = Transaction.builder()
                .transactionId(generatedId)
                .amount(dto.getAmount())
                .date(dto.getDate())
                .time(dto.getTime())
                .currency(dto.getCurrency())
                .customerName(dto.getCustomerName())
                .build();
        return repo.save(transaction);
    }
    public Transaction patchUpdate(Long id, TransactionResponseDTO dto)
    {
        Transaction existing = repo.findById(id).orElseThrow(() -> new RuntimeException("Transaction not found with ID: " + id));

        if (dto.getTransactionId() != null)
            existing.setTransactionId(dto.getTransactionId());
        if (dto.getAmount() != null)
            existing.setAmount(dto.getAmount());
        if (dto.getDate() != null)
            existing.setDate(dto.getDate());
        if (dto.getTime() != null)
            existing.setTime(dto.getTime());
        if (dto.getCurrency() != null)
            existing.setCurrency(dto.getCurrency());
        if (dto.getCustomerName() != null)
            existing.setCustomerName(dto.getCustomerName());
        return repo.save(existing);
    }
    public Transaction searchByTransactionId(String transactionId) {
        Transaction transaction = repo.findByTransactionId(transactionId);
        if (transaction == null) {
            throw new RuntimeException("Transaction not found with ID: " + transactionId);
        }
        return transaction;
    }
    public List<Transaction> getAll() {
        return repo.findAll();
    }
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Transaction not found with ID: " + id);
        }
        repo.deleteById(id);
    }
    public long countByDate(String date) {
        return repo.countByDate(date);
    }
}
