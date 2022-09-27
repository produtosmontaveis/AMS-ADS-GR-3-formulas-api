package com.produtos.montaveis.formulasapi.api.controller;

import com.produtos.montaveis.formulasapi.domain.model.polinomio.MonomioPolinomio;
import com.produtos.montaveis.formulasapi.domain.model.polinomio.MonomioPolinomioKey;
import com.produtos.montaveis.formulasapi.domain.model.polinomio.Polinomio;
import com.produtos.montaveis.formulasapi.domain.repository.SentencaRepository;
import com.produtos.montaveis.formulasapi.domain.repository.polinomio.MonomioPolinomioRepository;
import com.produtos.montaveis.formulasapi.domain.repository.polinomio.PolinomioRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/polinomios")
public class PolinomioController {

    final PolinomioRepository polinomioRepository;
    final MonomioPolinomioRepository monomioPolinomioRepository;
    final SentencaRepository sentencaRepository;

    @GetMapping
    public List<Polinomio> listPolinomios() {
        return polinomioRepository.findAll();
    }

    @GetMapping("/{polinomioId}")
    public ResponseEntity<Polinomio> getPolinomio(@PathVariable Long polinomioId) {
        if (!polinomioRepository.existsById(polinomioId)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(polinomioRepository.findById(polinomioId).orElseThrow());
    }

    @PostMapping("/sentenca/{sentencaId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Polinomio> addPolinomio(
            @PathVariable Long sentencaId,
            @RequestBody Polinomio polinomio) {
        if (!sentencaRepository.existsById(sentencaId)) {
            return ResponseEntity.notFound().build();
        }
        polinomio.setSentenca(sentencaRepository.findById(sentencaId).orElseThrow());
        Polinomio newPolinomio = polinomioRepository.save(polinomio);
        Set<MonomioPolinomio> monomiosCompletos = polinomio.getMonomios();
        monomiosCompletos.forEach(monomioPolinomio -> {
                monomioPolinomio.setPolinomio(newPolinomio);
                monomioPolinomio.setId(
                        new MonomioPolinomioKey(newPolinomio.getId(), monomioPolinomio.getMonomio().getId())
                );
        });
        monomioPolinomioRepository.saveAll(monomiosCompletos);
        return ResponseEntity.ok(polinomio);
    }
}
