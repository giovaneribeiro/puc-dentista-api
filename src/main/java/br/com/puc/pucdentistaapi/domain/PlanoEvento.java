package br.com.puc.pucdentistaapi.domain;

import java.math.BigDecimal;

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
@Table(name = "TB_PLANO_EVENTO")
public class PlanoEvento {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "plano_id", nullable = false)
  private Plano plano;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "evento_id", nullable = false)
  private Evento evento;

  @Column(name = "preco")
  private BigDecimal preco;
}
