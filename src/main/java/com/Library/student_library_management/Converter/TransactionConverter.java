package com.Library.student_library_management.Converter;

import com.Library.student_library_management.model.Transaction;
import com.Library.student_library_management.requestDTO.TransactionRequestDTO;

public class TransactionConverter {
    public static Transaction convertTransactionRequestDtoIntoTransaction(TransactionRequestDTO transactionRequestDTO){
        Transaction transaction=new Transaction();
        transaction.setDueDate(transactionRequestDTO.getDueDate());
        transaction.setFine(transactionRequestDTO.getFine());
        transaction.setTransactionType(transactionRequestDTO.getTransactionType());
        return transaction;
    }
}
