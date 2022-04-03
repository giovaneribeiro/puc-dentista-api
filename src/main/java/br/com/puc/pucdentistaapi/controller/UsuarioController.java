package br.com.puc.pucdentistaapi.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.puc.pucdentistaapi.domain.Usuario;
import br.com.puc.pucdentistaapi.model.LoginDTO;
import br.com.puc.pucdentistaapi.model.TokenDTO;
import br.com.puc.pucdentistaapi.model.UsuarioDTO;
import br.com.puc.pucdentistaapi.service.TokenService;
import br.com.puc.pucdentistaapi.service.UsuarioService;
import br.com.puc.pucdentistaapi.utils.HashUtil;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

  @Autowired
  private UsuarioService usuarioService;

  @Autowired
  private TokenService tokenService;

  @GetMapping(value = "/geraSenha/{senha}")
  public String geraSenha(@PathVariable(value = "senha") String senha) {
    try {
      return HashUtil.hash(senha);
    } catch (NoSuchAlgorithmException e) {
      return "nada a fazer";
    }
  }

  @PostMapping(value = "/login")
  public ResponseEntity<TokenDTO> login(@RequestBody LoginDTO dto) {
    Optional<Usuario> usuario = usuarioService.obterPorEmailSenha(dto.getUsuario(), dto.getSenha());

    if (usuario.isPresent()) {
      Optional<TokenDTO> token = tokenService.obterToken(usuario.get().getId());
      return ResponseEntity.of(token);
    }

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
  }

  @GetMapping(value = "/{token}")
  public ResponseEntity<UsuarioDTO> obterPorToken(@PathVariable(value = "token") String token) {
    Optional<UsuarioDTO> usuario = tokenService.obterUsuarioPorToken(token);
    return ResponseEntity.of(usuario);
  }
}
