package br.com.puc.pucdentistaapi.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.puc.pucdentistaapi.domain.Comentario;
import br.com.puc.pucdentistaapi.domain.Paciente;
import br.com.puc.pucdentistaapi.domain.Tratamento;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TratamentoIndividualDTO {

  private Integer id;
  private String paciente;
  private String plano;
  private String cpf;
  private Integer idade;
  private String status;
  private List<ComentarioDTO> comentarios;
  private List<EventosIndividualDTO> eventos;

  public TratamentoIndividualDTO(Tratamento tratamento) {
    Paciente paciente = tratamento.getPaciente();

    this.id = tratamento.getId();
    this.paciente = paciente.getNome();
    this.plano = paciente.getPlano().getNome();
    this.cpf = paciente.getCpf();
    this.idade = Period.between(paciente.getNascimento(), LocalDate.now()).getYears();
    this.status = tratamento.getStatus();
    this.comentarios = tratamento.getComentarios().stream().map(ComentarioDTO::new)
        .sorted(Comparator.comparing(ComentarioDTO::getCriacao))
        .collect(Collectors.toCollection(ArrayList::new));
    this.eventos = tratamento.getEventos().stream().map(EventosIndividualDTO::new)
        .collect(Collectors.toCollection(ArrayList::new));
  }
}
