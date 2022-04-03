package br.com.puc.pucdentistaapi.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.puc.pucdentistaapi.domain.UsuarioToken;

public interface UsuarioTokenRepository extends JpaRepository<UsuarioToken, Integer> {

  @Query(" SELECT ut FROM UsuarioToken ut WHERE ut.usuario.id = :id AND ut.expiresAt > :agora ")
  List<UsuarioToken> findAllByUsuarioId(Integer id, LocalDateTime agora);

  Optional<UsuarioToken> findByToken(String token);
}
