package com.trabalho.pooII.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trabalho.pooII.dto.CadastroRequestDTO;
import com.trabalho.pooII.dto.CadastroResponseDTO;
import com.trabalho.pooII.dto.LoginRequestDTO;
import com.trabalho.pooII.dto.LoginResponseDTO;
import com.trabalho.pooII.dto.enums.TipoUsuario;
import com.trabalho.pooII.model.Medico;
import com.trabalho.pooII.model.Paciente;
import com.trabalho.pooII.model.Usuario;
import com.trabalho.pooII.repository.MedicoRepository;
import com.trabalho.pooII.repository.PacienteRepository;
import com.trabalho.pooII.repository.UsuarioRepository;
import com.trabalho.pooII.services.interfaces.Login;

@Service
public class LoginService implements Login {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;
    
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    @Transactional
    public CadastroResponseDTO cadastrar(CadastroRequestDTO dto) {
        List<String> errors = new ArrayList<>();

        // ------------ VALIDAÇÕES GENÉRICAS PARA USUÁRIOS
        
        if (dto.getNomeUsuario() == null || dto.getNomeUsuario().isBlank()) {
            errors.add("nomeUsuario é obrigatório");
        }
        if (dto.getEmailUsuario() == null || dto.getEmailUsuario().isBlank()) {
            errors.add("emailUsuario é obrigatório");
        }
        if (dto.getSenhaUsuario() == null || dto.getSenhaUsuario().isBlank()) {
            errors.add("senhaUsuario é obrigatório");
        }
        if (dto.getTipoUsuario() == null || (dto.getTipoUsuario() != 1 && dto.getTipoUsuario() != 2)) {
            errors.add("tipoUsuario deve ser 1 ou 2");
        }

        // ------------------------



        // ------------ VALIDAÇÕES ESPECÍFICAS PARA PACIENTE

        if (dto.getTipoUsuario().equals(TipoUsuario.PACIENTE) && (!dto.getCrmMedico().isEmpty() || !dto.getEspecialidadeMedico().isEmpty())){
            errors.add("Para paciente, não precisa informar ESPECIALIDADE ou CRM.");    
        }

        if (dto.getTipoUsuario().equals(TipoUsuario.PACIENTE) && dto.getDataNascimentoPaciente().equals(null)){
            errors.add("Para Paciente, Necessário informar data de nascimento");    
        }

        if (dto.getTipoUsuario().equals(TipoUsuario.PACIENTE) && dto.getCpfPaciente().isEmpty()){
            errors.add("Para Paciente, Necessário informar CPF");    
        }

        // ---------------------------------


        // ------------ VALIDAÇÕES ESPECÍFICAS PARA MÉDICO

        if (dto.getTipoUsuario().equals(TipoUsuario.MEDICO) && (!dto.getCpfPaciente().isEmpty() || !dto.getDataNascimentoPaciente().equals(null))){
            errors.add("Para médico, não precisa informar CPF ou Data Nascimento");    
        }

        if (dto.getTipoUsuario().equals(TipoUsuario.MEDICO) && dto.getCrmMedico().equals(null)){
            errors.add("Para médico, Necessário informar CRM");    
        }

        if (dto.getTipoUsuario().equals(TipoUsuario.MEDICO) && dto.getEspecialidadeMedico().isEmpty()){
            errors.add("Para médico, Necessário informar Especialidade");    
        }

        // ---------------------------------


        // Em caso de erro, encerra cadastro
        if (!errors.isEmpty()) {
            return new CadastroResponseDTO(false, errors);
        }

        // Valida se usuário já existe no banco
        if (usuarioRepository.findByEmailUsuario(dto.getEmailUsuario()).isPresent()) {
            errors.add("Email já cadastrado");
            return new CadastroResponseDTO(false, errors);
        }

        // Cria e salva usuário
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario(dto.getNomeUsuario());
        usuario.setEmailUsuario(dto.getEmailUsuario());
        usuario.setSenhaUsuario(passwordEncoder.encode(dto.getSenhaUsuario()));
        usuario.setTipoUsuario(dto.getTipoUsuario());
        
        usuarioRepository.save(usuario);

        // Cria corretamente paciente ou médico baseado no seu tipo
        if (dto.getTipoUsuario().equals(TipoUsuario.MEDICO)){
            medicoRepository.save(
                new Medico(usuario, dto.getCrmMedico(), dto.getEspecialidadeMedico())
            );
        } else if (dto.getTipoUsuario().equals(TipoUsuario.PACIENTE)){
            pacienteRepository.save(
                new Paciente(usuario, dto.getCpfPaciente(), dto.getDataNascimentoPaciente())
        );
        }

        // Retorna validação e transação como finalizada
        return new CadastroResponseDTO(true, new ArrayList<>());
    }

    @Override
    public LoginResponseDTO logar(LoginRequestDTO loginRequest) {
        List<String> errors = new ArrayList<>();

        if (loginRequest.getEmailUsuario() == null || loginRequest.getEmailUsuario().isBlank()) {
            errors.add("emailUsuario é obrigatório");
        }
        if (loginRequest.getSenhaUsuario() == null || loginRequest.getSenhaUsuario().isBlank()) {
            errors.add("senhaUsuario é obrigatório");
        }

        if (!errors.isEmpty()) {
            return new LoginResponseDTO(false, errors);
        }

        Usuario usuario = usuarioRepository.findByEmailUsuario(loginRequest.getEmailUsuario())
                .orElse(null);

        if (usuario == null || !passwordEncoder.matches(loginRequest.getSenhaUsuario(), usuario.getSenhaUsuario())) {
            errors.add("Email ou senha inválidos");
            return new LoginResponseDTO(false, errors);
        }

        return new LoginResponseDTO(true, new ArrayList<>(), usuario.getNomeUsuario(), usuario.getTipoUsuario());
    }
}