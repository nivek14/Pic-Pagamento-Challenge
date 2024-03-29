package com.example.PicPagamento.controllers;

import com.example.PicPagamento.domain.transaction.Transaction;
import com.example.PicPagamento.dtos.TransactionDTO;
import com.example.PicPagamento.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transaction) throws Exception {
        Transaction newTransaction = this.transactionService.crateTransaction(transaction);
        return new ResponseEntity<>(newTransaction, HttpStatus.OK);
    }


}
