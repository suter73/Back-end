package com.trabalho.pooII.services;

import com.trabalho.pooII.dto.CadastroRequestDTO;
import com.trabalho.pooII.dto.CadastroResponseDTO;
import com.trabalho.pooII.model.Usuario;
import com.trabalho.pooII.repository.UsuarioRepository;
import com.trabalho.pooII.services.interfaces.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService implements Login {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public CadastroResponseDTO cadastrar(CadastroRequestDTO dto) {
        List<String> errors = new ArrayList<>();

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

        if (!errors.isEmpty()) {
            return new CadastroResponseDTO(false, errors);
        }

        if (usuarioRepository.findByEmailUsuario(dto.getEmailUsuario()).isPresent()) {
            errors.add("Email já cadastrado");
            return new CadastroResponseDTO(false, errors);
        }

        Usuario usuario = new Usuario();
        usuario.setNomeUsuario(dto.getNomeUsuario());
        usuario.setEmailUsuario(dto.getEmailUsuario());
        usuario.setSenhaUsuario(passwordEncoder.encode(dto.getSenhaUsuario()));
        usuario.setTipoUsuario(dto.getTipoUsuario());

        usuarioRepository.save(usuario);

        return new CadastroResponseDTO(true, new ArrayList<>());
    }

    @Override
    public void entrar() {}
}