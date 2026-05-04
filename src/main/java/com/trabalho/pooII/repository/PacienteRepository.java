package com.trabalho.pooII.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalho.pooII.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{
    
}
