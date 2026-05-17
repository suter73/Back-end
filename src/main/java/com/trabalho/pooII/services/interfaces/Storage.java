package com.trabalho.pooII.services.interfaces;

import org.springframework.web.multipart.MultipartFile;

public interface Storage {
    public MultipartFile baixarDocumento(String caminho);
    public void salvarDocumento(MultipartFile arquivo, String caminho);
    public void deletarDocumento(String caminho);
    public boolean existeDocumento(String caminho);
}
