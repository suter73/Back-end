package com.trabalho.pooII.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "exame")
public class Exame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idExame")
    private Long idExame;

    @ManyToOne
    @JoinColumn(name = "idPaciente", nullable = false)
    private Paciente paciente;

    @Column(name = "tipoExame", length = 20, nullable = false)
    private String tipoExame;

    @Column(name = "caminhoArquivo", length = 45)
    private String caminhoArquivo;

    public Exame() {}

    public Exame(Paciente paciente, String tipoExame) {
        this.paciente = paciente;
        this.tipoExame = tipoExame;
    }

    public Long getIdExame() { return idExame; }
    public void setIdExame(Long idExame) { this.idExame = idExame; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public String getTipoExame() { return tipoExame; }
    public void setTipoExame(String tipoExame) { this.tipoExame = tipoExame; }

    public String getCaminhoArquivo() { return caminhoArquivo; }
    public void setCaminhoArquivo(String caminhoArquivo) { this.caminhoArquivo = caminhoArquivo; }
}
