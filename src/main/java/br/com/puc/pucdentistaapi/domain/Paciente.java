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
@Table(name = "TB_PACIENTE")
public class Paciente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "plano_id", nullable = false)
  private Plano plano;

  @Column(name = "nome")
  private String nome;

  @Column(name = "cpf")
  private String cpf;

  @Column(name = "nascimento", columnDefinition = "DATE")
  private LocalDate nascimento;

  @Column(name = "inicio", columnDefinition = "DATE")
  private LocalDate inicio;

  @Column(name = "fim", columnDefinition = "DATE")
  private LocalDate fim;
}
