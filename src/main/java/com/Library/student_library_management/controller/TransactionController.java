package com.Library.student_library_management.controller;

import com.Library.student_library_management.model.Transaction;
import com.Library.student_library_management.requestDTO.TransactionRequestDTO;
import com.Library.student_library_management.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction/apis")
public class TransactionController {
    private TransactionService transactionService;
    @Autowired
    private TransactionController(TransactionService transactionService){
        this.transactionService=transactionService;
    }
    @PostMapping("/save")
    public String saveTransaction(@RequestBody TransactionRequestDTO transactionRequestDTO){
        String response=transactionService.addTransaction(transactionRequestDTO);
        return response;
    }

    @GetMapping("/find/{id}")
    public Transaction findTransactionById(@PathVariable int id){
        return transactionService.findAuthorById(id);
    }

    @GetMapping("/findAll")
    public List<Transaction> findAllTransaction(){
        return transactionService.findAllTransaction();
    }

    @PutMapping("/update/{id}")
    public Transaction updateTransaction(@PathVariable int id, @RequestBody TransactionRequestDTO transactionRequestDTO){
        return transactionService.updateTransaction(id,transactionRequestDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTransaction(int id){
        return transactionService.deleteTransaction(id);
    }
}
