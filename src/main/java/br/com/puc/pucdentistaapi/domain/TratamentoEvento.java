package br.com.puc.pucdentistaapi.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_TRATAMENTO_EVENTO")
public class TratamentoEvento {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tratamento_id", nullable = false)
  private Tratamento tratamento;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "evento_id", nullable = false)
  private Evento evento;

  @Column(name = "realizacao", columnDefinition = "DATE")
  private LocalDate realizacao;

  @Column(name = "preco_original")
  private BigDecimal precoOriginal;

  @Column(name = "preco_final")
  private BigDecimal precoFinal;
}
