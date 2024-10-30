package com.luan.picpay_desafio.dto;

import com.luan.picpay_desafio.domain.Transaction;
import com.luan.picpay_desafio.domain.User;

import java.math.BigDecimal;

public class TransactionDTO {

    private BigDecimal transactionValue;
    private Long payerId;
    private Long payeeId;

    public TransactionDTO(BigDecimal transactionValue, Long payerId, Long payeeId) {
        this.transactionValue = transactionValue;
        this.payerId = payerId;
        this.payeeId = payeeId;
    }

    public TransactionDTO(Transaction transaction){
        setTransactionValue(transaction.getTransactionValue());
        setPayerId(transaction.getPayerId());
        setPayeeId(transaction.getPayeeId());
    }

    public BigDecimal getTransactionValue() {
        return transactionValue;
    }

    public void setTransactionValue(BigDecimal transactionValue) {
        this.transactionValue = transactionValue;
    }

    public Long getPayerId() {
        return payerId;
    }

    public void setPayerId(Long payerId) {
        this.payerId = payerId;
    }

    public Long getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(Long payeeId) {
        this.payeeId = payeeId;
    }
}
