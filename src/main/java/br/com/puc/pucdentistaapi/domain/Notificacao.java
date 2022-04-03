package br.com.puc.pucdentistaapi.domain;

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
@Table(name = "TB_NOTIFICACAO")
public class Notificacao {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "dentista_id", nullable = false)
  private Dentista dentista;

  @Column(name = "tipo")
  private String tipo;

  @Column(name = "descricao")
  private String descricao;

  @Column(name = "lida")
  private boolean lida;

  @Column(name = "leitura", columnDefinition = "TIMESTAMP")
  private LocalDateTime leitura;
}
