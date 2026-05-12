package com.trabalho.pooII.dto.enums;

public enum TipoUsuario {

    PACIENTE(1),
    MEDICO(2);

    private final Integer codigo;

    TipoUsuario(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo(){
        return codigo;
    }
}
