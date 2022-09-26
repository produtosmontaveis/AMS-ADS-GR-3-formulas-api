package com.produtos.montaveis.formulasapi.domain.model.monomio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "tb_monomio")
public class Monomio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private char operador;

    private int coeficiente;

    @ManyToMany
    @JoinTable(
            name = "tb_termo_monomio",
            joinColumns = @JoinColumn(name = "monomio_id"),
            inverseJoinColumns = @JoinColumn(name = "termo_id")
    )
    private List<Termo> termos = new ArrayList<>();

    public void addTermosToMonomio(List<Termo> termos) {
        this.termos.addAll(termos);
    }
}
