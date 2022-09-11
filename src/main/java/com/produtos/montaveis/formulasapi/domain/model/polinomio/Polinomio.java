package com.produtos.montaveis.formulasapi.domain.model.polinomio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.produtos.montaveis.formulasapi.domain.model.Sentenca;
import com.produtos.montaveis.formulasapi.domain.model.monomio.Monomio;
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

    private int expoente;

    private int posicao;

    @OneToMany(mappedBy = "polinomio")
    private Set<MonomioPolinomio> monomios;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "polinomio_id")
    private Sentenca sentenca;

}
