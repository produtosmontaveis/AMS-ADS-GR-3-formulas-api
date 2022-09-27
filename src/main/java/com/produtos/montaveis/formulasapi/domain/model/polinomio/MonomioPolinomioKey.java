package com.produtos.montaveis.formulasapi.domain.model.polinomio;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class MonomioPolinomioKey implements Serializable {

    @Column(name = "polinomio_id")
    private Long polinomioId;

    @Column(name = "monomio_id")
    private Long monomioId;

    public MonomioPolinomioKey() {}

    public MonomioPolinomioKey(Long polinomioId, Long monomioId) {
        this.polinomioId = polinomioId;
        this.monomioId = monomioId;
    }
}
