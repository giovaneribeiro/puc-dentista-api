package br.com.puc.pucdentistaapi.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.puc.pucdentistaapi.domain.Usuario;
import br.com.puc.pucdentistaapi.domain.UsuarioToken;
import br.com.puc.pucdentistaapi.model.TokenDTO;
import br.com.puc.pucdentistaapi.model.UsuarioDTO;
import br.com.puc.pucdentistaapi.repository.UsuarioTokenRepository;

@Service
public class TokenService {

  @Autowired
  private UsuarioTokenRepository usuarioTokenRepository;

  public Optional<TokenDTO> obterToken(Integer id) {
    List<UsuarioToken> usuarioToken = usuarioTokenRepository.findAllByUsuarioId(id, LocalDateTime.now());

    TokenDTO token = new TokenDTO();

    if (usuarioToken.isEmpty()) {
      token.setToken(criarToken(id));
    } else {
      UsuarioToken ut = usuarioToken.get(0);
      token.setToken(ut.getToken());
    }

    return Optional.of(token);
  }

  private String criarToken(Integer id) {
    UsuarioToken usuarioToken = new UsuarioToken();

    Usuario usuario = new Usuario();
    usuario.setId(id);

    usuarioToken.setUsuario(usuario);

    LocalDateTime agora = LocalDateTime.now();

    usuarioToken.setCreatedAt(agora);
    usuarioToken.setExpiresAt(agora.plusMinutes(10));

    String token = id + UUID.randomUUID().toString();
    usuarioToken.setToken(token);

    usuarioTokenRepository.save(usuarioToken);

    return token;
  }

  public Optional<UsuarioDTO> obterUsuarioPorToken(String token) {
    Optional<UsuarioToken> ut = usuarioTokenRepository.findByToken(token);

    if (ut.isPresent()) {
      UsuarioDTO usuario = new UsuarioDTO(ut.get());
      return Optional.of(usuario);
    }

    return Optional.empty();
  }

}
