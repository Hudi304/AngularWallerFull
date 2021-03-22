package com.proiectPS.demo.controllers;


import com.proiectPS.demo.DTO.LoginRequest;
import com.proiectPS.demo.DTO.RegisterRequest;
import com.proiectPS.demo.model.User;
import com.proiectPS.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        System.out.println("dsadsadsa");
        this.userRepository = userRepository;
    }


    @GetMapping("/users")
    public List<User> getUsers() {
        System.out.println("Got a GET on /users");
        return (List<User>) userRepository.findAll();

    }

    @PostMapping("/users")
    void addUser(@RequestBody User user) {
        System.out.println("got a POSt on /users");
        userRepository.save(user);
    }

    @PostMapping("/login")
    void login(@RequestBody LoginRequest loginRequest) {
        System.out.println("got a POSt on /login");
        List<User> usrs = userRepository.findByNickname(loginRequest.name);
        System.out.println(usrs);

    }

    @PostMapping("/register")
    void register() {
        System.out.println("got a POSt on /register");

        //todo validari


        //userRepository.save(new User(registerRequest.nickname,registerRequest.email,registerRequest.password));

        //todo cred cca ar trebui sa returneze un token care sa-mi dea dupa aia voie sa accesez restul paginilor

        //todo send a register respons (valid, date invalide, user already exists, email already used etc...)

    }



//    @GetMapping("/login")
//    void login(@RequestBody LoginRequest loginRequest) {
//        System.out.println("got a POSt on /login");
//        List<User> usrs = userRepository.findByNickname(loginRequest.name);
//
//        System.out.println(usrs);
//
//    }

}
