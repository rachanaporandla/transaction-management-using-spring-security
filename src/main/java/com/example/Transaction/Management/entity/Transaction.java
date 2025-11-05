package com.example.Transaction.Management.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "transaction_id", unique = true, nullable = false, length = 19)
    private String transactionId;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false, length = 8)
    private String date;

    @Column(nullable = false, length = 6)
    private String time;

    @Column(nullable = false, length = 3)
    private String currency;

    @Column(name = "customer_name", nullable = false)
    private String customerName;
}