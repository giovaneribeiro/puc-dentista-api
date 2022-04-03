package br.com.puc.pucdentistaapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.puc.pucdentistaapi.model.ComentarioDTO;
import br.com.puc.pucdentistaapi.model.TratamentoDTO;
import br.com.puc.pucdentistaapi.model.TratamentoIndividualDTO;
import br.com.puc.pucdentistaapi.service.TratamentoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/tratamento")
public class TratamentoController {

  @Autowired
  private TratamentoService tratamentoService;

  // TODO: realizar controle de token via request header

  @GetMapping(value = "/dentista/{id}")
  public ResponseEntity<List<TratamentoDTO>> obterTratamentoPorDentista(@PathVariable(value = "id") Integer id) {
    return ResponseEntity.ok(tratamentoService.obterTratamentoPorDentista(id));
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<TratamentoIndividualDTO> obterTratamentoPorCodigo(@PathVariable(value = "id") Integer id) {
    return ResponseEntity.of(tratamentoService.obterTratamento(id));
  }

  @PostMapping(value = "/{id}/comentario")
  public ResponseEntity<ComentarioDTO> adicionarComentario(@PathVariable(value = "id") Integer id,
      @RequestBody ComentarioDTO dto) {
    return ResponseEntity.accepted().body(tratamentoService.salvarComentario(id, dto));
  }
}
