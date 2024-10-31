package com.luan.picpay_desafio.controllers;

import com.luan.picpay_desafio.dto.UserDTO;
import com.luan.picpay_desafio.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @PutMapping(path = "/create")
    public ResponseEntity<Void> createUser(@RequestBody UserDTO dto){
        userService.createUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
