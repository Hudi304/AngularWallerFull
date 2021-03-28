package com.proiectPS.demo.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.proiectPS.demo.DTO.LoginRequest;
import com.proiectPS.demo.DTO.LoginResponse;
import com.proiectPS.demo.DTO.RegisterRequest;
import com.proiectPS.demo.DTO.RegisterResponse;
import com.proiectPS.demo.model.Admin;
import com.proiectPS.demo.model.Currency;
import com.proiectPS.demo.model.Transasction;
import com.proiectPS.demo.model.User;
import com.proiectPS.demo.repository.AdminRepository;
import com.proiectPS.demo.repository.CurrencyRepository;
import com.proiectPS.demo.repository.TransactionRepository;
import com.proiectPS.demo.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserRepository userRepository;
    private final AdminRepository adminRepository;
    private final CurrencyRepository currencyRepository;
    private final TransactionRepository transactionRepository;
    ObjectMapper mapper;

    public UserController(UserRepository userRepository, AdminRepository adminRepository, CurrencyRepository currencyRepository, TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.adminRepository = adminRepository;
        this.currencyRepository = currencyRepository;
        this.transactionRepository = transactionRepository;
        mapper =  new ObjectMapper();
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
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        System.out.println("got a POSt on /login");

        LoginResponse logRes  =  new LoginResponse();

        User usr = userRepository.findFirstByNickname(loginRequest.nickname);
        Admin admin = adminRepository.findFirstByNickname(loginRequest.nickname);

        if(usr != null) {
            logRes.foundUser = true;
            logRes.isAdmin = false;
        }else if(admin != null){
            logRes.isAdmin =  true;
            logRes.foundUser = true;
        }

        System.out.println(usr);
        return logRes;
    }

    @PostMapping("/register")
    public RegisterResponse register(@RequestBody RegisterRequest registerRequest) {
        System.out.println("/register : got RegisterRequest " + registerRequest.nickname + " " + registerRequest.password);
        RegisterResponse regRes =  new RegisterResponse(false ,false ,false );
        User newUser = new User(registerRequest.nickname,
                                registerRequest.email,
                                registerRequest.password);
        //todo validari
        if( userRepository.existsByNickname(newUser.getNickname()) &&
                adminRepository.existsAdminByNickname(newUser.getNickname()))
        {
            regRes.nicknameAlreadyUsed = true;
            System.out.println("Username already exists");
        }
        if(userRepository.existsByEmail(newUser.getEmail()) &&
                adminRepository.existsAdminByEmail(newUser.getEmail()))
        {
            regRes.emailAlreadyUsed = true;
            System.out.println("Email already exists");
        }

        if(!regRes.emailAlreadyUsed &&
                !regRes.nicknameAlreadyUsed)
        {
            userRepository.save(newUser);
            System.out.println("saved user");
        }

        return regRes;
        //todo cred cca ar trebui sa returneze un token care sa-mi dea dupa aia voie sa accesez restul paginilor
        //todo send a register respons (valid, date invalide, user already exists, email already used etc...)
    }

    @PostMapping("/admin")
    public ResponseEntity removeUser(@RequestBody String nickanme){
        System.out.println("removed" + nickanme);
        User usr =  userRepository.findFirstByNickname(nickanme);
        userRepository.delete(usr);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/admin/currencys")
    public List<Currency> fetchCurrencies(){
        System.out.println("got a GET on /admin/currencys ");
        List<Currency> curr  = (List<Currency>) currencyRepository.findAll();
        System.out.println(curr);
        return curr;
    }

    @GetMapping("/admin/transactions")
    public  List<Transasction> fetchtransactionas(){
        System.out.println("got GET on /admin/transactions");
        List<Transasction> transactions = (List<Transasction>) transactionRepository.findAll();
        return transactions;
    }



}
