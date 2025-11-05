package com.example.Transaction.Management.controller;

import com.example.Transaction.Management.dto.TransactionRequestDTO;
import com.example.Transaction.Management.dto.TransactionResponseDTO;
import com.example.Transaction.Management.entity.Transaction;
import com.example.Transaction.Management.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }
    @PostMapping("/doTransaction")
    public ResponseEntity<?> doTransaction(@Valid @RequestBody TransactionRequestDTO dto) {
        Transaction saved = service.create(dto);
        return ResponseEntity.ok(saved);
    }
    @PatchMapping("/updateTransaction/{id}")
    public ResponseEntity<?> patchUpdateTransaction(@PathVariable Long id, @RequestBody TransactionResponseDTO dto) {
        Transaction updated = service.patchUpdate(id, dto);
        return ResponseEntity.ok(updated);
    }
    @GetMapping("/searchTransaction")
    public ResponseEntity<?> searchTransaction(@RequestParam String transactionId) {
        Transaction transaction = service.searchByTransactionId(transactionId);
        if (transaction == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(transaction);
    }
    @GetMapping
    public ResponseEntity<?> showAll() {
        return ResponseEntity.ok(service.getAll());
    }
    @DeleteMapping("/deleteTransaction/{id}")
    public ResponseEntity<?> deleteTransaction(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Transaction deleted successfully");
    }
    @GetMapping("/getTransactionCount")
    public ResponseEntity<?> getTransactionCount(@RequestParam String date) {
        long count = service.countByDate(date);
        return ResponseEntity.ok(count);
    }
}