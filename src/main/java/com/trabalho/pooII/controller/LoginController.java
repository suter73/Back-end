package com.trabalho.pooII.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalho.pooII.dto.CadastroRequestDTO;
import com.trabalho.pooII.dto.CadastroResponseDTO;
import com.trabalho.pooII.dto.LoginRequestDTO;
import com.trabalho.pooII.dto.LoginResponseDTO;
import com.trabalho.pooII.services.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/cadastro")
    public CadastroResponseDTO cadastrar(@RequestBody CadastroRequestDTO dto) {
        return loginService.cadastrar(dto);
    }

    @PostMapping()
    public LoginResponseDTO logar(@RequestBody LoginRequestDTO dto) {
        return loginService.logar(dto);
    }
}