package com.luan.picpay_desafio.services;

import com.luan.picpay_desafio.domain.User;
import com.luan.picpay_desafio.dto.UserDTO;
import com.luan.picpay_desafio.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public void createUser(UserDTO userDTO){
        User user = new User(userDTO);

        userRepository.save(user);
    }

    public UserDTO findById(Long id){
        return new UserDTO(userRepository.findById(id).orElseThrow());
    }
}
