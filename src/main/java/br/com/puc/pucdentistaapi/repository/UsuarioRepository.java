package br.com.puc.pucdentistaapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.puc.pucdentistaapi.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

  Optional<Usuario> findByEmailAndSenha(String email, String senha);
}
