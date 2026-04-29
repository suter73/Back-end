package com.trabalho.pooII.controller;

import com.trabalho.pooII.dto.CadastroRequestDTO;
import com.trabalho.pooII.dto.CadastroResponseDTO;
import com.trabalho.pooII.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/cadastro")
    public CadastroResponseDTO cadastrar(@RequestBody CadastroRequestDTO dto) {
        return loginService.cadastrar(dto);
    }
}