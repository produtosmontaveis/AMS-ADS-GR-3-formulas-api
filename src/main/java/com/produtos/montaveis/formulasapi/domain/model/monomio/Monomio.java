package com.produtos.montaveis.formulasapi.domain.model.monomio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "tb_monomio")
public class Monomio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private char operador;

    private int coeficiente;

    @Embedded
    private Termo termo;
}
