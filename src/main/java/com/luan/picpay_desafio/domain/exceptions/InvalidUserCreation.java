package com.luan.picpay_desafio.domain.exceptions;

public class InvalidUserCreation extends RuntimeException {

    public InvalidUserCreation(String msg){
        super(msg);
    }
}
