package com.trabalho.pooII.services.interfaces;

import com.trabalho.pooII.dto.CadastroRequestDTO;
import com.trabalho.pooII.dto.CadastroResponseDTO;
import com.trabalho.pooII.dto.LoginRequestDTO;
import com.trabalho.pooII.dto.LoginResponseDTO;

public interface Login {
    CadastroResponseDTO cadastrar(CadastroRequestDTO dto);
    LoginResponseDTO logar(LoginRequestDTO loginRequets);
}