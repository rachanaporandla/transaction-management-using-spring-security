package com.example.Transaction.Management.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionResponseDTO {
    private String transactionId;
    private Double amount;
    private String date;
    private String time;
    private String currency;
    private String customerName;
}
