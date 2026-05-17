package com.trabalho.pooII.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.trabalho.pooII.model.Exame;
import com.trabalho.pooII.services.ExameService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;


@RestController()
@RequestMapping("/exames")
public class ExamesController {

    @Autowired
    private ExameService exameService;

    @PostMapping("/documento/enviar")
    public ResponseEntity<Exame> enviarDocumentoExame(
        @RequestParam Long idPaciente,
        @RequestParam String tipoExame,
        @RequestPart("arquivo") MultipartFile arquivo
    ) {
        Exame exame = exameService.enviarDocumentoExame(idPaciente, tipoExame, arquivo);
        return ResponseEntity.ok(exame);
    }

    @GetMapping("/documento/baixar")
    public ResponseEntity<MultipartFile> baixarDocumentoExame(
        @RequestParam Long idPaciente,
        @RequestParam Long idExame
    ) {
        return ResponseEntity.ok(exameService.baixarDocumentoExame(idPaciente, idExame));
    }
}
