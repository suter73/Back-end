package com.trabalho.pooII.dto;

public class LoginRequestDTO {
    private String emailUsuario;
    private String senhaUsuario;

    public String getSenhaUsuario(){
        return this.senhaUsuario;
    }

    public String getEmailUsuario(){
        return this.emailUsuario;
    }
}
