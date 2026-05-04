package com.trabalho.pooII.dto.enums;

public enum TipoUsuario {

    MEDICO(1),
    PACIENTE(2);

    private final Integer codigo;

    TipoUsuario(Integer codigo) {
        this.codigo = codigo;
    }
}
