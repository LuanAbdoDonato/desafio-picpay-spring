package com.luan.picpay_desafio.controllers;

import com.luan.picpay_desafio.domain.Transaction;
import com.luan.picpay_desafio.dto.TransactionDTO;
import com.luan.picpay_desafio.services.TransactionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @Transactional
    @PostMapping(path = "/transfer")
    public ResponseEntity<Void> transfer(@RequestBody Transaction transaction){

        transactionService.transfer(transaction);

        return ResponseEntity.ok().build();
    }

}
