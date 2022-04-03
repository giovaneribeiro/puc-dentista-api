package br.com.puc.pucdentistaapi.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.puc.pucdentistaapi.domain.TratamentoEvento;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EventosIndividualDTO {
  
  private Integer id;
  private String evento;
  private BigDecimal precoOriginal;
  private BigDecimal precoFinal;
  private LocalDate realizacao;
  private String observacoes;

  public EventosIndividualDTO(TratamentoEvento evento) {
    this.id = evento.getId();
    this.evento = evento.getEvento().getDescricao();
    this.precoOriginal = evento.getPrecoOriginal();
    this.precoFinal = evento.getPrecoFinal();
    this.realizacao = evento.getRealizacao();
  }
}
