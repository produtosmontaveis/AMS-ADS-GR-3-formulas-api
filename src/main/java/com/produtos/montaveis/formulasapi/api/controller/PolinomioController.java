package com.produtos.montaveis.formulasapi.api.controller;

import com.produtos.montaveis.formulasapi.domain.model.Sentenca;
import com.produtos.montaveis.formulasapi.domain.model.monomio.Monomio;
import com.produtos.montaveis.formulasapi.domain.model.polinomio.MonomioPolinomio;
import com.produtos.montaveis.formulasapi.domain.model.polinomio.MonomioPolinomioKey;
import com.produtos.montaveis.formulasapi.domain.model.polinomio.Polinomio;
import com.produtos.montaveis.formulasapi.domain.repository.MonomioPolinomioRepository;
import com.produtos.montaveis.formulasapi.domain.repository.MonomioRepository;
import com.produtos.montaveis.formulasapi.domain.repository.PolinomioRepository;
import com.produtos.montaveis.formulasapi.domain.repository.SentencaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/polinomios")
public class PolinomioController {

    final MonomioRepository monomioRepository;
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
        Sentenca sentenca = sentencaRepository.findById(sentencaId).orElseThrow();
        polinomio.setSentenca(sentenca);
        return ResponseEntity.ok(polinomioRepository.save(polinomio));
    }

    @PostMapping("/{polinomioId}")
    public ResponseEntity<MonomioPolinomio> addMonomioToPolinomio(
            @PathVariable Long polinomioId,
            @RequestBody MonomioPolinomio monomioCompleto) {
        Monomio monomio = monomioRepository.findById(monomioCompleto.getMonomio().getId()).orElseThrow();
        Polinomio polinomio = polinomioRepository.findById(polinomioId).orElseThrow();
        monomioCompleto.setId(new MonomioPolinomioKey(polinomioId, monomio.getId()));
        monomioCompleto.setPolinomio(polinomio);
        monomioCompleto.setMonomio(monomio);
        return ResponseEntity.ok(monomioPolinomioRepository.save(monomioCompleto));
    }

}
