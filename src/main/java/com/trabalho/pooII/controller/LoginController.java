package com.trabalho.pooII.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.trabalho.pooII.services.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping()
    public void login(@RequestBody String entity) {
        loginService.Entrar();
    }
     
    @PostMapping("/cadastrar")
    public void cadasstrar(@RequestBody String entity) {
        loginService.Cadastrar();
    }

}
