package com.luan.picpay_desafio.domain;

import com.luan.picpay_desafio.domain.enums.UserType;
import com.luan.picpay_desafio.dto.UserDTO;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "full_name")
    private String fullName;

    @JoinColumn(name = "cpf/cnpj")
    private String cpfCnpj;

    @JoinColumn(name = "email")
    private String email;

    @JoinColumn(name = "password")
    private String password;

    @JoinColumn(name = "User_type")
    private UserType type;

    @JoinColumn(name = "balance")
    private BigDecimal balance;

    public User(String fullName, String cpfCnpj, String email, String password, UserType type, BigDecimal balance) {
        this.fullName = fullName;
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.password = password;
        this.type = type;
        this.balance = balance;
    }

    public User() {
    }

    public User(UserDTO dto){
        setFullName(dto.getFullName());
        setCpfCnpj(dto.getCpfCnpj());
        setEmail(dto.getEmail());
        setPassword(dto.getPassword());
        setType(dto.getType());
        setBalance(dto.getBalance());
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserType getType() {
        return type;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
