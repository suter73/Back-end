package com.trabalho.pooII.dto;

import java.util.List;

public class CadastroResponseDTO {

    private boolean sucess;
    private List<String> errors;

    public CadastroResponseDTO(boolean sucess, List<String> errors) {
        this.sucess = sucess;
        this.errors = errors;
    }

    public boolean isSucess() { return sucess; }
    public List<String> getErrors() { return errors; }
}