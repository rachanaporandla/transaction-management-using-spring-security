package com.example.Transaction.Management.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionIdGenerator {

    private static TransactionIdGenerator instance;

    private TransactionIdGenerator() {}

    public static synchronized TransactionIdGenerator getInstance() {
        if (instance == null) {
            instance = new TransactionIdGenerator();
        }
        return instance;
    }
    public String generateTransactionId() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
        String dateTime = dateFormat.format(new Date());
        return "47000" + dateTime;
    }
}
