package com.produtos.montaveis.formulasapi.domain.model.binomio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.produtos.montaveis.formulasapi.domain.model.Sentenca;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity(name = "tb_binomio")
public class Binomio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int expoente;

    @OneToMany(mappedBy = "binomio")
    private Set<MonomioBinomio> monomios;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "sentenca_id")
    private Sentenca sentenca;
}
