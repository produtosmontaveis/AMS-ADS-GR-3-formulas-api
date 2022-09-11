package com.produtos.montaveis.formulasapi.api.controller;

import com.produtos.montaveis.formulasapi.domain.model.Sentenca;
import com.produtos.montaveis.formulasapi.domain.repository.SentencaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/sentencas")
public class SentencaController {

    final SentencaRepository sentencaRepository;

    @GetMapping
    public List<Sentenca> listSentenca() {
        return sentencaRepository.findAll();
    }

    @GetMapping("/{sentencaId}")
    public ResponseEntity<Sentenca> getSentenca(@PathVariable Long sentencaId) {
        if (!sentencaRepository.existsById(sentencaId)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sentencaRepository.findById(sentencaId).orElseThrow());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Sentenca> addSentenca(@RequestBody Sentenca sentenca) {
        return ResponseEntity.ok(sentencaRepository.save(sentenca));
    }

}
