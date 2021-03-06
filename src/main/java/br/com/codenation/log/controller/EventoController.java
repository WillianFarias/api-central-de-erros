package br.com.codenation.log.controller;

import br.com.codenation.log.controller.advice.ResourceNotFoundException;
import br.com.codenation.log.controller.especificacao.EspecificaoCustomizada;
import br.com.codenation.log.dto.EventoDTO;
import br.com.codenation.log.mappers.EventoMapper;
import br.com.codenation.log.model.Evento;
import br.com.codenation.log.service.interfaces.EventoServiceInterface;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    private EventoServiceInterface eventoService;

    EventoController(EventoMapper eventoMapper){
        this.eventoMapper = eventoMapper;
    }

    private final EventoMapper eventoMapper;

    private EspecificaoCustomizada especificaoCustomizada;

    @PostMapping
    @ApiOperation("Cria novo evento de log")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Evento de log criado com sucesso")})
    public ResponseEntity<Evento> create(@Valid @RequestBody Evento evento) {
        return new ResponseEntity<Evento>(this.eventoService.save(evento), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Evento> update(@Valid @RequestBody Evento evento) {
        return new ResponseEntity<Evento>(this.eventoService.save(evento), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Evento não encontrado"),
            @ApiResponse(code = 200, message = "Evento localizado")})
    public ResponseEntity<Evento> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<Evento>(this.eventoService.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Evento")), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.eventoService.deleteById(id);
    }

    @GetMapping
    public ResponseEntity<Page<EventoDTO>> findCustomers(EspecificaoCustomizada especificaoCustomizada, Pageable pageable) {
        Page<Evento> eventos = eventoService.findAll(especificaoCustomizada, pageable);
        Page<EventoDTO> eventoDTO = eventos.map(eventoMapper::mapToDTO);
        return new ResponseEntity<>(eventoDTO, HttpStatus.OK);
    }
}
