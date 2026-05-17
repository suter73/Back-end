package com.trabalho.pooII.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.trabalho.pooII.model.Exame;
import com.trabalho.pooII.model.Paciente;
import com.trabalho.pooII.repository.ExameRepository;
import com.trabalho.pooII.repository.PacienteRepository;

@Service
public class ExameService {

    @Autowired
    private SupabaseService supabaseService;

    @Autowired
    private ExameRepository exameRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Transactional
    public Exame enviarDocumentoExame(Long idPaciente, String tipoExame, MultipartFile arquivo) {
        Paciente paciente = pacienteRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado com id: " + idPaciente));

        Exame exame = new Exame(paciente, tipoExame);
        exame = exameRepository.save(exame);

        String nomeArquivo = arquivo.getOriginalFilename();
        String caminho = idPaciente + "/" + exame.getIdExame() + "/" + nomeArquivo;
        
        if (caminho.length() > 45) {
            String extensao = nomeArquivo != null && nomeArquivo.contains(".")
                    ? nomeArquivo.substring(nomeArquivo.lastIndexOf("."))
                    : "";
            caminho = idPaciente + "/" + exame.getIdExame() + "/doc" + extensao;
        }

        supabaseService.salvarDocumento(arquivo, caminho);

        exame.setCaminhoArquivo(caminho);
        return exameRepository.save(exame);
    }

    public MultipartFile baixarDocumentoExame(Long idPaciente, Long idExame) {
        return null;
    }
}
