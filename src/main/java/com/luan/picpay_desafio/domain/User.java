package com.luan.picpay_desafio.domain;

import com.luan.picpay_desafio.domain.enums.UserType;
import jakarta.persistence.*;

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

    public User(String fullName, String cpfCnpj, String email, String password, UserType type) {
        this.fullName = fullName;
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }
}
