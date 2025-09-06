package com.Library.student_library_management.service;

import com.Library.student_library_management.Converter.TransactionConverter;
import com.Library.student_library_management.model.Book;
import com.Library.student_library_management.model.Card;
import com.Library.student_library_management.model.Transaction;
import com.Library.student_library_management.repository.BookRepository;
import com.Library.student_library_management.repository.CardRepository;
import com.Library.student_library_management.repository.TransactionRepository;
import com.Library.student_library_management.requestDTO.TransactionRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    private TransactionRepository transactionRepository;
    private BookRepository bookRepository;
    private CardRepository cardRepository;
    @Autowired
    private TransactionService(TransactionRepository transactionRepository,
                               BookRepository bookRepository,
                               CardRepository cardRepository){
        this.transactionRepository=transactionRepository;
        this.bookRepository=bookRepository;
        this.cardRepository=cardRepository;
    }
    public String addTransaction(TransactionRequestDTO transactionRequestDTO){
        Transaction transaction= TransactionConverter.convertTransactionRequestDtoIntoTransaction(transactionRequestDTO);
        Book book=bookRepository.findById(transactionRequestDTO.getBookId()).get();
        transaction.setBook(book);
        Card card=cardRepository.findById(transactionRequestDTO.getCardId()).get();
        transaction.setCard(card);
        transactionRepository.save(transaction);
        return("Transaction Saved Successfully");
    }

    public Transaction findAuthorById(int id){
        Optional<Transaction> transaction=transactionRepository.findById(id);
        if(transaction.isPresent()){
            return transaction.get();
        }
        else {
            return null;
        }
    }

    public List<Transaction> findAllTransaction(){
        return transactionRepository.findAll();
    }

    public Transaction updateTransaction(int id, TransactionRequestDTO transactionRequestDTO){
        Transaction transaction= findAuthorById(id);
        if(transaction!=null){
            transaction.setDueDate(transactionRequestDTO.getDueDate());
            transaction.setFine(transactionRequestDTO.getFine());
            transaction.setTransactionType(transactionRequestDTO.getTransactionType());
            transactionRepository.save(transaction);
            return transaction;
        }
        else {
            return null;
        }
    }

    public String deleteTransaction(int id){
        transactionRepository.deleteById(id);
        return "Transaction Deleted Successfully..!!";
    }
}
