package com.produtos.montaveis.formulasapi.api.controller;

import com.produtos.montaveis.formulasapi.domain.model.monomio.Monomio;
import com.produtos.montaveis.formulasapi.domain.repository.monomio.MonomioRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/monomios")
public class MonomioController {

    final MonomioRepository monomioRepository;

    @GetMapping
    public List<Monomio> listMonomios() {
        return monomioRepository.findAll();
    }

    @GetMapping("/{monomioId}")
    public ResponseEntity<Monomio> getMonomio(@PathVariable Long monomioId) {
        if (!monomioRepository.existsById(monomioId)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(monomioRepository.findById(monomioId).orElseThrow());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Monomio> addMonomio(@RequestBody Monomio monomio) {
        return ResponseEntity.ok(monomioRepository.save(monomio));
    }

    @PutMapping("/{monomioId}")
    public ResponseEntity<Monomio> updateMonomio(
            @PathVariable Long monomioId,
            @RequestBody Monomio monomio) {
        if (!monomioRepository.existsById(monomioId)) {
            return ResponseEntity.notFound().build();
        }
        monomio.setId(monomioId);
        return ResponseEntity.ok(monomioRepository.save(monomio));
    }


    @DeleteMapping("/{monomioId}")
    public ResponseEntity<Monomio> deleteMonomio(@PathVariable Long monomioId) {
        if (!monomioRepository.existsById(monomioId)) {
            return ResponseEntity.notFound().build();
        }
        monomioRepository.deleteById(monomioId);
        return ResponseEntity.noContent().build();
    }
}
