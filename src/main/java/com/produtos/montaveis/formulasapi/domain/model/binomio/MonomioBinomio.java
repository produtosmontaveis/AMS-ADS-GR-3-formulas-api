package com.produtos.montaveis.formulasapi.domain.model.binomio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.produtos.montaveis.formulasapi.domain.model.monomio.Monomio;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "tb_monomio_binomio")
public class MonomioBinomio {

    @JsonIgnore
    @EmbeddedId
    MonomioBinomioKey id;

    @JsonIgnore
    @ManyToOne
    @MapsId("binomioId")
    @JoinColumn(name = "binomio_id")
    private Binomio binomio;

    @ManyToOne
    @MapsId("monomioId")
    @JoinColumn(name = "monomio_id")
    private Monomio monomio;

    private int posicao;
}
