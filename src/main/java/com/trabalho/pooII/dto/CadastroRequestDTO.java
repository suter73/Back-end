package com.trabalho.pooII.dto;

public class CadastroRequestDTO {

    private String nomeUsuario;
    private String senhaUsuario;
    private String emailUsuario;
    private Integer tipoUsuario;

    public String getNomeUsuario() { return nomeUsuario; }
    public void setNomeUsuario(String nomeUsuario) { this.nomeUsuario = nomeUsuario; }

    public String getSenhaUsuario() { return senhaUsuario; }
    public void setSenhaUsuario(String senhaUsuario) { this.senhaUsuario = senhaUsuario; }

    public String getEmailUsuario() { return emailUsuario; }
    public void setEmailUsuario(String emailUsuario) { this.emailUsuario = emailUsuario; }

    public Integer getTipoUsuario() { return tipoUsuario; }
    public void setTipoUsuario(Integer tipoUsuario) { this.tipoUsuario = tipoUsuario; }
}