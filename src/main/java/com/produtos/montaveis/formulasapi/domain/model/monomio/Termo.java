package com.produtos.montaveis.formulasapi.domain.model.monomio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "tb_termo")
public class Termo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private char variavel;

    private int expoente;

    @JsonIgnore
    @ManyToMany(mappedBy = "termos")
    private List<Monomio> monomios;
}
