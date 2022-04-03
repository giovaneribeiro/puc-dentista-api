package br.com.puc.pucdentistaapi.model;

import java.util.Arrays;
import java.util.List;

import br.com.puc.pucdentistaapi.domain.Dentista;
import br.com.puc.pucdentistaapi.domain.Usuario;
import br.com.puc.pucdentistaapi.domain.UsuarioToken;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioDTO {

  private Integer id;
  private Integer idUsuario;
  private String dentista;
  private String nome;
  private String cpf;
  private String cnpj;
  private List<String> permissions;

  public UsuarioDTO(UsuarioToken usuarioToken) {
    Usuario usuario = usuarioToken.getUsuario();
    Dentista dentista = usuario.getDentista();

    this.id = dentista.getId();
    this.idUsuario = usuario.getId();
    this.dentista = dentista.getNome();
    this.nome = usuario.getNome();
    this.cpf = dentista.getCpf();
    this.cnpj = dentista.getCnpj();
    this.permissions = Arrays.asList(usuario.getTipo());
  }
}
