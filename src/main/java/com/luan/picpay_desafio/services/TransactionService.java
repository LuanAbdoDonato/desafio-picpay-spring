package com.luan.picpay_desafio.services;

import com.luan.picpay_desafio.domain.Transaction;
import com.luan.picpay_desafio.domain.User;
import com.luan.picpay_desafio.domain.enums.UserType;
import com.luan.picpay_desafio.domain.exceptions.InvalidTransaction;
import com.luan.picpay_desafio.dto.TransactionDTO;
import com.luan.picpay_desafio.dto.UserDTO;
import com.luan.picpay_desafio.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class TransactionService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionRepository transactionRepository;

    public void transfer(Transaction transaction){

        User payer = userService.findById(transaction.getPayerId());
        User payee = userService.findById(transaction.getPayeeId());

        payer.setBalance(payer.getBalance().subtract(transaction.getTransactionValue()));
        payee.setBalance(payee.getBalance().add(transaction.getTransactionValue()));

        userService.saveUser(payee);
        userService.saveUser(payer);

        transactionRepository.save(transaction);

        if (validatePayer(payer, payee) || validateBalance(payer, transaction.getTransactionValue()) || validateAuthorizationService()){
            throw new InvalidTransaction("insufficient balance or payer is a merchant");
        }

    }

    public boolean validatePayer(User payer, User payee){
        return payer.getType() == UserType.MERCHANT || payer.equals(payee);
    }

    public boolean validateBalance(User  payer, BigDecimal balance){
        return payer.getBalance().compareTo(balance) < 0;
    }

    public boolean validateAuthorizationService(){
        Map status= restTemplate.getForObject("https://util.devi.tools/api/v2/authorize", Map.class);

        if(!"success".equals(status.get("status")) && "true".equals(status.get("data"))){
            return true;
        }
        return false;
    }
}
