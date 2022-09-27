package com.produtos.montaveis.formulasapi.api.controller;

import com.produtos.montaveis.formulasapi.domain.model.binomio.Binomio;
import com.produtos.montaveis.formulasapi.domain.model.binomio.MonomioBinomio;
import com.produtos.montaveis.formulasapi.domain.model.binomio.MonomioBinomioKey;
import com.produtos.montaveis.formulasapi.domain.repository.SentencaRepository;
import com.produtos.montaveis.formulasapi.domain.repository.binomio.BinomioRepository;
import com.produtos.montaveis.formulasapi.domain.repository.binomio.MonomioBinomioRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/binomios")
public class BinomioController {

    final BinomioRepository binomioRepository;
    final MonomioBinomioRepository monomioBinomioRepository;
    final SentencaRepository sentencaRepository;

    @GetMapping
    public List<Binomio> listBinomios() {
        return binomioRepository.findAll();
    }

    @GetMapping("/{binomioId}")
    public ResponseEntity<Binomio> getBinomio(@PathVariable Long binomioId) {
        if (!binomioRepository.existsById(binomioId)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(binomioRepository.findById(binomioId).orElseThrow());
    }

    @PostMapping("/sentenca/{sentencaId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Binomio> addBinomio(
            @PathVariable Long sentencaId,
            @RequestBody Binomio binomio) {
        if (!sentencaRepository.existsById(sentencaId)) {
            return ResponseEntity.notFound().build();
        }
        binomio.setSentenca(sentencaRepository.findById(sentencaId).orElseThrow());
        Binomio newBinomio = binomioRepository.save(binomio);
        Set<MonomioBinomio> monomiosCompletos = binomio.getMonomios();
        monomiosCompletos.forEach(monomioBinomio -> {
            monomioBinomio.setBinomio(newBinomio);
            monomioBinomio.setId(
                    new MonomioBinomioKey(newBinomio.getId(), monomioBinomio.getMonomio().getId())
            );
        });
        monomioBinomioRepository.saveAll(monomiosCompletos);
        return ResponseEntity.ok(newBinomio);
    }
}
