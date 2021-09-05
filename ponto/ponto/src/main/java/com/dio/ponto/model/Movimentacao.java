package com.dio.ponto.model;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Movimentacao {

    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public class movimentacaoId implements Serializable{
        private long idMovimento;
        private long idUsuario;
    }

    @EmbeddedId
    private movimentacaoId id;
    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    private BigDecimal periodo;
    @ManyToOne(targetEntity = Ocorrencia.class)
    private Ocorrencia ocorrencia;
    @ManyToOne(targetEntity = Calendario.class)
    private Calendario calendario;
}
