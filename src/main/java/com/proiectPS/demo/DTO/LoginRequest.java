package com.proiectPS.demo.DTO;

import lombok.AllArgsConstructor;



@AllArgsConstructor
public class LoginRequest {

    public String name;
    public String password;


    public LoginRequest(){
    }
}
