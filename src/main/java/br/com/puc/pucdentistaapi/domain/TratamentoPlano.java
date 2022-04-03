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
@Table(name = "TB_TRATAMENTO_PLANO")
public class TratamentoPlano {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tratamento_id", nullable = false)
  private Tratamento tratamento;

  @Column(name = "conta")
  private String conta;

  @Column(name = "valor")
  private BigDecimal valor;

  @Column(name = "pagamento", columnDefinition = "DATE")
  private LocalDate pagamento;
}
