package com.luan.picpay_desafio.domain;

import com.luan.picpay_desafio.dto.TransactionDTO;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn (name = "balance")
    private BigDecimal transactionValue;

    @JoinColumn (name = "payerId")
    private Long payerId;

    @JoinColumn (name = "payeeId")
    private Long payeeId;

    public Transaction(BigDecimal transactionValue, Long payerId, Long payeeId) {
        this.transactionValue = transactionValue;
        this.payerId = payerId;
        this.payeeId = payeeId;
    }

    public Transaction(){
    }

    public Transaction(TransactionDTO dto){
        setPayeeId(dto.getPayeeId());
        setPayerId(dto.getPayerId());
        setTransactionValue(dto.getTransactionValue());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
