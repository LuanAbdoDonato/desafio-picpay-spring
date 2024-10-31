package com.luan.picpay_desafio.dto;

import com.luan.picpay_desafio.domain.User;
import com.luan.picpay_desafio.domain.enums.UserType;

public class UserDTO {

    private String fullName;
    private String cpfCnpj;
    private String email;
    private String password;
    private UserType type;

    public UserDTO(String fullName, String cpfCnpj, String email, String password, UserType type) {
        this.fullName = fullName;
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public UserDTO(User user){
       setFullName(user.getFullName());
       setCpfCnpj(user.getCpfCnpj());
       setEmail(user.getEmail());
       setPassword(user.getPassword());
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
