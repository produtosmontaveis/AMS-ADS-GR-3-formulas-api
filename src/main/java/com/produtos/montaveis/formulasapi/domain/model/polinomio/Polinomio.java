package com.produtos.montaveis.formulasapi.domain.model.polinomio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.produtos.montaveis.formulasapi.domain.model.Sentenca;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity(name = "tb_polinomio")
public class Polinomio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "polinomio")
    private Set<MonomioPolinomio> monomios;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "sentenca_id")
    private Sentenca sentenca;
}
