package br.com.puc.pucdentistaapi.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.puc.pucdentistaapi.domain.Tratamento;
import br.com.puc.pucdentistaapi.domain.TratamentoEvento;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TratamentoDTO {

  private Integer id;
  private String paciente;
  private String plano;
  private LocalDateTime inicio;
  private BigDecimal valorTotal;
  private String status;

  public TratamentoDTO(Tratamento tratamento) {
    this.id = tratamento.getId();
    this.paciente = tratamento.getPaciente().getNome();
    this.plano = tratamento.getPaciente().getPlano().getNome();
    this.inicio = tratamento.getCriacao();
    this.status = tratamento.getStatus();
    this.valorTotal = tratamento.getEventos().stream().map(TratamentoEvento::getPrecoFinal).reduce(BigDecimal.ZERO, BigDecimal::add);
  }
}
