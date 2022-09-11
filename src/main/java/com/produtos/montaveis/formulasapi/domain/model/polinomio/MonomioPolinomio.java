package com.produtos.montaveis.formulasapi.domain.model.polinomio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.produtos.montaveis.formulasapi.domain.model.monomio.Monomio;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "tb_monomio_polinomio")
public class MonomioPolinomio {

    @JsonIgnore
    @EmbeddedId
    MonomioPolinomioKey id;

    @JsonIgnore
    @ManyToOne
    @MapsId("polinomioId")
    @JoinColumn(name = "polinomio_id")
    private Polinomio polinomio;

    @ManyToOne
    @MapsId("monomioId")
    @JoinColumn(name = "monomio_id")
    private Monomio monomio;

    private int posicao;
}
