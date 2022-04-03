package br.com.puc.pucdentistaapi.service;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.puc.pucdentistaapi.domain.Usuario;
import br.com.puc.pucdentistaapi.repository.UsuarioRepository;
import br.com.puc.pucdentistaapi.utils.HashUtil;

@Service
public class UsuarioService {
  
  @Autowired
  private UsuarioRepository usuarioRepository;

  public Optional<Usuario> obterPorEmailSenha(String email, String senha) {
    try {
      return usuarioRepository.findByEmailAndSenha(email, HashUtil.hash(senha));
    } catch (NoSuchAlgorithmException e) {
      return Optional.empty();
    }
  }
}
