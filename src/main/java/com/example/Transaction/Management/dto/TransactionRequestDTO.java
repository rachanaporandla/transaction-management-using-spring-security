package com.example.Transaction.Management.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionRequestDTO {

    @Pattern(regexp = "47000\\d{14}", message = "Transaction ID must follow format 47000DDMMYYYYHHMMSS")
    @NotNull(message = "Transaction ID cannot be null")
    private String transactionId;

    @Min(value = 1, message = "Amount should be greater than 0")
    private double amount;

    @Pattern(regexp = "\\d{8}", message = "Date must be in ddmmyyyy format")
    private String date;

    @Pattern(regexp = "\\d{6}", message = "Time must be 6 digits in hhmmss format")
    private String time;

    @Pattern(regexp = "INR", message = "Currency must be INR")
    private String currency;

    @NotBlank(message = "Customer name cannot be empty")
    private String customerName;
}
