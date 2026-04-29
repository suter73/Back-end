package com.trabalho.pooII.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(length = 150, nullable = false)
    private String nomeUsuario;

    @Column(length = 60, nullable = false, unique = true)
    private String emailUsuario;

    @Column(length = 60, nullable = false)
    private String senhaUsuario;

    @Column(nullable = false)
    private Integer tipoUsuario;

    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }

    public String getNomeUsuario() { return nomeUsuario; }
    public void setNomeUsuario(String nomeUsuario) { this.nomeUsuario = nomeUsuario; }

    public String getEmailUsuario() { return emailUsuario; }
    public void setEmailUsuario(String emailUsuario) { this.emailUsuario = emailUsuario; }

    public String getSenhaUsuario() { return senhaUsuario; }
    public void setSenhaUsuario(String senhaUsuario) { this.senhaUsuario = senhaUsuario; }

    public Integer getTipoUsuario() { return tipoUsuario; }
    public void setTipoUsuario(Integer tipoUsuario) { this.tipoUsuario = tipoUsuario; }
}