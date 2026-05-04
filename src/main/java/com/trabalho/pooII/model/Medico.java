package com.trabalho.pooII.model;

import jakarta.persistence.*;

@Entity
@Table(name = "medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedico;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @Column(name = "crmMedico", length = 20, nullable = false, unique = true)
    private String crmMedico;

    @Column(name = "especialidadeMedico", nullable = false)
    private String especialidadeMedico;

    public Medico(
        Usuario usuario,
        String crmMedico,
        String especialidadeMedico
    ){
        this.usuario = usuario;
        this.crmMedico = crmMedico;
        this.especialidadeMedico = especialidadeMedico;
    }

    public Long getIdMedico() { return idMedico; }
    public void setIdMedico(Long idMedico) { this.idMedico = idMedico; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public String getCrmMedico() { return crmMedico; }
    public void setCrmMedico(String crmMedico) { this.crmMedico = crmMedico; }

    public String getEspecialidadeMedico() { return especialidadeMedico; }
    public void setEspecialidadeMedico(String especialidadeMedico) { this.especialidadeMedico = especialidadeMedico; }
}
