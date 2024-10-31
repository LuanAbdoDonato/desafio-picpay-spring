package com.luan.picpay_desafio.services;

import com.luan.picpay_desafio.domain.User;
import com.luan.picpay_desafio.domain.exceptions.InvalidTransaction;
import com.luan.picpay_desafio.domain.exceptions.InvalidUserCreation;
import com.luan.picpay_desafio.dto.UserDTO;
import com.luan.picpay_desafio.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserDTO> getAllUsers(){
        List<User> users = userRepository.findAll();

        List<UserDTO> dto = new ArrayList<>();

        for(User u : users){
            dto.add(new UserDTO(u));
        }
        return dto;
    }

    public void createUser(User user){
        if(validateEmailUser(user) || validateCpfCnpjUser(user)){
            throw new InvalidUserCreation("cpf/cnpj or email are invalid");
        }
        userRepository.save(user);
    }

    private boolean validateCpfCnpjUser(User user) {
        List<User> users = userRepository.findAll();

        Set<String> cpfCnpj = new HashSet<>();

        users.forEach(x -> cpfCnpj.add(x.getCpfCnpj()));

        return cpfCnpj.contains(user.getCpfCnpj());
    }

    private boolean validateEmailUser(User user) {
        List<User> users = userRepository.findAll();

        Set<String> email = new HashSet<>();

        users.forEach(x -> email.add(x.getEmail()));

        return email.contains(user.getEmail());
    }

    public User findById(Long id){
        return userRepository.getReferenceById(id);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }
}
