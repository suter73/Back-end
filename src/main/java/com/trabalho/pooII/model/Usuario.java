package com.trabalho.pooII.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(name = "nomeUsuario", length = 150, nullable = false)
    private String nomeUsuario;

    @Column(name = "emailUsuario", length = 60, nullable = false, unique = true)
    private String emailUsuario;

    @Column(name = "senhaUsuario", length = 60, nullable = false)
    private String senhaUsuario;

    @Column(name = "tipoUsuario", nullable = false)
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