package br.com.puc.pucdentistaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.puc.pucdentistaapi.domain.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {

}
