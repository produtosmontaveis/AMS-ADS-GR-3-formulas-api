package com.produtos.montaveis.formulasapi.domain.model.monomio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class Termo {

    private char variavel;

    private int expoente;
}
