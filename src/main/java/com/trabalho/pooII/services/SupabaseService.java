package com.trabalho.pooII.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;

import com.trabalho.pooII.config.SupabaseConfig;
import com.trabalho.pooII.services.interfaces.Storage;

@Service
public class SupabaseService implements Storage {

    @Autowired
    private WebClient supabaseWebClient;

    @Autowired
    private SupabaseConfig supabaseConfig;

    @Override
    public MultipartFile baixarDocumento(String caminho) {
        return null;
    }

    @Override
    public void salvarDocumento(MultipartFile arquivo, String caminho) {
        try {
            supabaseWebClient.post()
                    .uri("/object/" + supabaseConfig.getBucket() + "/" + caminho)
                    .header(HttpHeaders.CONTENT_TYPE, arquivo.getContentType())
                    .bodyValue(arquivo.getBytes())
                    .retrieve()
                    .toBodilessEntity()
                    .block();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar documento no Supabase: " + e.getMessage(), e);
        }
    }

    @Override
    public void deletarDocumento(String caminho) {
        throw new RuntimeException("Método ainda não implementado");
    }

    @Override
    public boolean existeDocumento(String caminho) {
        throw new RuntimeException("Método ainda não implementado");
    }
}
