package com.dio.ponto.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Localidade {

    @Id
    private long id;
    @ManyToOne(targetEntity = NivelAcesso.class)
    private NivelAcesso nivelAcesso;
    private String descricao;
}
