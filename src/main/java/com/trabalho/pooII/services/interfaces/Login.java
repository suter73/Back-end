package com.trabalho.pooII.services.interfaces;

import com.trabalho.pooII.dto.CadastroRequestDTO;
import com.trabalho.pooII.dto.CadastroResponseDTO;

public interface Login {
    CadastroResponseDTO cadastrar(CadastroRequestDTO dto);
    void entrar();
}