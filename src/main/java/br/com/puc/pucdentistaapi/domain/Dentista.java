package br.com.puc.pucdentistaapi.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_DENTISTA")
public class Dentista {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "nome")
  private String nome;

  @Column(name = "cpf")
  private String cpf;

  @Column(name = "cnpj")
  private String cnpj;

  @Column(name = "ativo")
  private boolean ativo;

  @Column(name = "inicio", columnDefinition = "DATE")
  private LocalDate inicio;

  @Column(name = "fim", columnDefinition = "DATE")
  private LocalDate fim;
}
