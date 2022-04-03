package br.com.puc.pucdentistaapi.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
@Table(name = "TB_TRATAMENTO_PAGAMENTO")
public class TratamentoPagamento {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tratamento_id", nullable = false)
  private Tratamento tratamento;

  @Column(name = "conta")
  private String conta;

  @Column(name = "valor")
  private BigDecimal valor;

  @Column(name = "pagamento", columnDefinition = "TIMESTAMP")
  private LocalDateTime pagamento;
}
