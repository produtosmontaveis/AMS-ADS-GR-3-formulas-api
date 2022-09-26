package com.produtos.montaveis.formulasapi.api.controller;

import com.produtos.montaveis.formulasapi.domain.model.monomio.Monomio;
import com.produtos.montaveis.formulasapi.domain.model.monomio.Termo;
import com.produtos.montaveis.formulasapi.domain.repository.TermoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/termos")
public class TermoController {

    final TermoRepository termoRepository;

    @GetMapping
    public List<Termo> listTermos() {
        return termoRepository.findAll();
    }

    @GetMapping("/{termoId}")
    public ResponseEntity<Termo> getTermo(@PathVariable Long termoId) {
        if (!termoRepository.existsById(termoId)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(termoRepository.findById(termoId).orElseThrow());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Termo> addTermo(@RequestBody Termo termo) {
        return ResponseEntity.ok(termoRepository.save(termo));
    }

    @PutMapping
    public ResponseEntity<Termo> updateTermo(
            @PathVariable Long termoId,
            @RequestBody Termo termo) {
        if (!termoRepository.existsById(termoId)) {
            return ResponseEntity.notFound().build();
        }
        termo.setId(termoId);
        return ResponseEntity.ok(termoRepository.save(termo));
    }

    @DeleteMapping("/{termoId}")
    public ResponseEntity<Termo> deleteTermo(@PathVariable Long termoId) {
        if (!termoRepository.existsById(termoId)) {
            return ResponseEntity.notFound().build();
        }

        termoRepository.deleteById(termoId);
        return ResponseEntity.noContent().build();
    }
}
