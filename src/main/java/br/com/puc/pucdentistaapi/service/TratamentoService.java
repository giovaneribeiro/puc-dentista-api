package br.com.puc.pucdentistaapi.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.puc.pucdentistaapi.domain.Comentario;
import br.com.puc.pucdentistaapi.domain.Tratamento;
import br.com.puc.pucdentistaapi.domain.Usuario;
import br.com.puc.pucdentistaapi.model.ComentarioDTO;
import br.com.puc.pucdentistaapi.model.TratamentoDTO;
import br.com.puc.pucdentistaapi.model.TratamentoIndividualDTO;
import br.com.puc.pucdentistaapi.repository.ComentarioRepository;
import br.com.puc.pucdentistaapi.repository.TratamentoRepository;

@Service
public class TratamentoService {

  @Autowired
  private TratamentoRepository tratamentoRepository;

  @Autowired
  private ComentarioRepository comentarioRepository;

  public List<TratamentoDTO> obterTratamentoPorDentista(Integer id) {
    return tratamentoRepository.findAllByDentistaIdOrderByIdDesc(id).stream().map(TratamentoDTO::new)
        .collect(Collectors.toCollection(ArrayList::new));
  }

  public Optional<TratamentoIndividualDTO> obterTratamento(Integer id) {
    Optional<Tratamento> tratamento = tratamentoRepository.findById(id);

    if (tratamento.isPresent()) {
      return Optional.of(new TratamentoIndividualDTO(tratamento.get()));
    }

    return Optional.empty();
  }

  public ComentarioDTO salvarComentario(Integer id, ComentarioDTO dto) {

    Usuario usuario = new Usuario();
    usuario.setId(dto.getCodigoUsuario());

    Tratamento tratamento = new Tratamento();
    tratamento.setId(id);

    Comentario comentario = new Comentario();
    comentario.setTratamento(tratamento);
    comentario.setDescricao(dto.getDescricao());
    comentario.setCriacao(LocalDateTime.now());
    comentario.setUsuario(usuario);

    return new ComentarioDTO(comentarioRepository.save(comentario));
  }
}
