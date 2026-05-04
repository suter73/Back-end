package com.trabalho.pooII.dto;

import java.util.List;

public class LoginResponseDTO {

    private boolean sucess;
    private List<String> errors;
    private String nomeUsuario;
    private Integer tipoUsuario;

    public LoginResponseDTO(boolean sucess, List<String> errors) {
        this.sucess = sucess;
        this.errors = errors;
    }

    public LoginResponseDTO(
        boolean sucess, 
        List<String> errors, 
        String nomeUsuario, 
        Integer tipoUsuario
    ) {
        this.sucess = sucess;
        this.errors = errors;
        this.nomeUsuario = nomeUsuario;
        this.tipoUsuario = tipoUsuario;
    }

    public boolean isSucess() { return sucess; }
    public List<String> getErrors() { return errors; }
    public String getNomeUsuario() { return nomeUsuario; }
    public Integer getTipoUsuario() { return tipoUsuario; }
}
