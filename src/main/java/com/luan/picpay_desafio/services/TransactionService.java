package com.luan.picpay_desafio.services;

import com.luan.picpay_desafio.domain.enums.UserType;
import com.luan.picpay_desafio.domain.exceptions.InvalidTransaction;
import com.luan.picpay_desafio.dto.TransactionDTO;
import com.luan.picpay_desafio.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionService {

    @Autowired
    UserService userService;

    public void transfer(TransactionDTO transaction){

        UserDTO payer = userService.findById(transaction.getPayerId());
        UserDTO payee = userService.findById(transaction.getPayeeId());

        if (validatePayer(payer, payee) || validateBalance(payer, transaction.getTransactionValue())){
            throw new InvalidTransaction("insufficient balance or payer is a merchant");
        }
    }

    public boolean validatePayer(UserDTO payer, UserDTO payee){
        return payer.getType() == UserType.MERCHANT || payer.equals(payee);
    }

    public boolean validateBalance(UserDTO payer, BigDecimal balance){
        return payer.getBalance().compareTo(balance) < 0;
    }
}
