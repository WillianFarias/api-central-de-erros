package br.com.codenation.controller;

import br.com.codenation.controller.especificacao.EspecificaoCustomizada;
import br.com.codenation.dto.EventoDTO;
import br.com.codenation.mappers.EventoMapper;
import br.com.codenation.model.Evento;
import br.com.codenation.service.interfaces.EventoServiceInterface;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.codenation.controller.advice.ResourceNotFoundException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    private EventoServiceInterface eventoService;

    private EventoMapper eventoMapper;

    private EspecificaoCustomizada especificaoCustomizada;

    @PostMapping
    @ApiOperation("Cria novo evento de log")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Evento de log criado com sucesso")})
    public ResponseEntity<Evento> create(@Valid @RequestBody Evento evento){
        return new ResponseEntity<Evento>(this.eventoService.save(evento), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Evento> update(@Valid @RequestBody Evento evento) {
        return new ResponseEntity<Evento>(this.eventoService.save(evento), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Evento não encontrado"),
            @ApiResponse(code = 200, message = "Evento localizado" )})
    public ResponseEntity<Evento> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<Evento>(this.eventoService.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Evento")), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.eventoService.deleteById(id);
    }

    /*@GetMapping
    public ResponseEntity<Page<EventoDTO>> findCustomers(EspecificaoCustomizada especificaoCustomizada, Pageable pageable){
        Page<Evento> eventoDTOS = eventoService.findAll(especificaoCustomizada ,pageable);
        return new ResponseEntity<>(eventoMapper.map(eventoDTOS), HttpStatus.OK);
    }*/

    /*
    @GetMapping
    public Iterable<Evento> findCustomers(EspecificaoCustomizada especificaoCustomizada, Pageable pageable){
        List<Evento> eventos = eventoService.findAll(especificaoCustomizada, pageable).getContent();
        return eventos;
    }*/

    @GetMapping
    public ResponseEntity<Page<EventoDTO>> findCustomers(EspecificaoCustomizada especificaoCustomizada, Pageable pageable){
        return new ResponseEntity<Page<EventoDTO>>(eventoService.findAll(especificaoCustomizada ,pageable), HttpStatus.OK);
    }
}
