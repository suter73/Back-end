package com.trabalho.pooII.dto;

import java.time.LocalDate;

public class CadastroRequestDTO {

    private String nomeUsuario;
    private String senhaUsuario;
    private String emailUsuario;
    private Integer tipoUsuario;
    private String crmMedico;
    private String especialidadeMedico;
    private String cpfPaciente;
    private LocalDate dataNascimentoPaciente;

    public String getCrmMedico() {return crmMedico;}
    
    public String getEspecialidadeMedico() {return especialidadeMedico;}
    
    public String getCpfPaciente() {return cpfPaciente;}
    
    public LocalDate getDataNascimentoPaciente() { return dataNascimentoPaciente;}
    
    public String getNomeUsuario() { return nomeUsuario; }

    public String getSenhaUsuario() { return senhaUsuario; }

    public String getEmailUsuario() { return emailUsuario; }

    public Integer getTipoUsuario() { return tipoUsuario; }
}