package com.trabalho.pooII.model;

import jakarta.persistence.*;

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
    private String dataNascimentoPaciente;

    public Paciente(
        Usuario usuario,
        String cpfPaciente,
        String dataNascimentoPaciente
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

    public String getDataNascimentoPaciente() { return dataNascimentoPaciente; }
    public void setDataNascimentoPaciente(String dataNascimentoPaciente) { this.dataNascimentoPaciente = dataNascimentoPaciente; }
}
