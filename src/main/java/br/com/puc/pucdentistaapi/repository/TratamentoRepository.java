package br.com.puc.pucdentistaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.puc.pucdentistaapi.domain.Tratamento;

public interface TratamentoRepository extends JpaRepository<Tratamento, Integer> {

  List<Tratamento> findAllByDentistaIdOrderByIdDesc(Integer id);
}
