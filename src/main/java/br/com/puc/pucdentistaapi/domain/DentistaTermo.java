package br.com.puc.pucdentistaapi.domain;

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
@Table(name = "TB_DENTISTA_TERMO")
public class DentistaTermo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "dentista_id", nullable = false)
  private Dentista dentista;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "termo_id", nullable = false)
  private TermoUso termo;

  @Column(name = "aceito")
  private boolean aceito;

  @Column(name = "aceitacao", columnDefinition = "DATE")
  private LocalDate aceitacao;
}
