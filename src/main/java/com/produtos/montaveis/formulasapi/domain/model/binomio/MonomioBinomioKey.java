package com.produtos.montaveis.formulasapi.domain.model.binomio;

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
public class MonomioBinomioKey implements Serializable {

    @Column(name = "binomio_id")
    private Long binomioId;

    @Column(name = "binomio_id")
    private Long monomioId;

    public MonomioBinomioKey() {}

    public MonomioBinomioKey(Long binomioId, Long monomioId) {
        this.binomioId = binomioId;
        this.monomioId = monomioId;
    }
}
