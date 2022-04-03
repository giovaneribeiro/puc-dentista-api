package br.com.puc.pucdentistaapi.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_TRATAMENTO")
public class Tratamento {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "dentista_id", nullable = false)
  private Dentista dentista;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "paciente_id", nullable = false)
  private Paciente paciente;

  @Column(name = "status")
  private String status;

  @Column(name = "criacao", columnDefinition = "TIMESTAMP")
  private LocalDateTime criacao;

  @Column(name = "atualizacao", columnDefinition = "TIMESTAMP")
  private LocalDateTime atualizacao;

  @OneToMany(mappedBy = "tratamento")
  private List<Comentario> comentarios;

  @OneToMany(mappedBy = "tratamento")
  private List<TratamentoEvento> eventos;
}
