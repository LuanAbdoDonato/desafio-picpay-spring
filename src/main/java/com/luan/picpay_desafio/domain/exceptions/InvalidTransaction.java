package com.luan.picpay_desafio.domain.exceptions;

public class InvalidTransaction extends RuntimeException {

    public InvalidTransaction(String msg){
        super(msg);
    }
}
