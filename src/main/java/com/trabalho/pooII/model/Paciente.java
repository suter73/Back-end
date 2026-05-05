package com.trabalho.pooII.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaciente;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @Column(name = "cpfPaciente", length = 14, nullable = false, unique = true)
    private String cpfPaciente;

    @Column(name = "dataNascimentoPaciente", nullable = false)
    private LocalDate dataNascimentoPaciente;

    public Paciente(
        Usuario usuario,
        String cpfPaciente,
        LocalDate dataNascimentoPaciente
    ){
        this.usuario = usuario;
        this.cpfPaciente = cpfPaciente;
        this.dataNascimentoPaciente = dataNascimentoPaciente;
    }

    public Long getIdPaciente() { return idPaciente; }
    public void setIdPaciente(Long idPaciente) { this.idPaciente = idPaciente; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public String getCpfPaciente() { return cpfPaciente; }
    public void setCpfPaciente(String cpfPaciente) { this.cpfPaciente = cpfPaciente; }

    public LocalDate getDataNascimentoPaciente() { return dataNascimentoPaciente; }
    public void setDataNascimentoPaciente(LocalDate dataNascimentoPaciente) { this.dataNascimentoPaciente = dataNascimentoPaciente; }
}
