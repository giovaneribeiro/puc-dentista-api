package br.com.puc.pucdentistaapi.model;

import java.time.LocalDateTime;

import br.com.puc.pucdentistaapi.domain.Comentario;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ComentarioDTO {

  private String descricao;
  private LocalDateTime criacao;
  private Integer codigoUsuario;
  private String nomeUsuario;

  public ComentarioDTO(Comentario comentario) {
    this.descricao = comentario.getDescricao();
    this.criacao = comentario.getCriacao();
    this.codigoUsuario = comentario.getUsuario().getId();
    this.nomeUsuario = comentario.getUsuario().getNome();
  }
}
