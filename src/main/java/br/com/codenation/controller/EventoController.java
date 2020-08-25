package br.com.codenation.controller;

import br.com.codenation.model.Evento;
import br.com.codenation.service.interfaces.EventoServiceInterface;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.codenation.controller.advice.ResourceNotFoundException;

import javax.validation.Valid;

@RestController
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    private EventoServiceInterface eventoService;

    @PostMapping
    @ApiOperation("Cria novo evento de log")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Evento de log criado com sucesso")})
    public ResponseEntity<Evento> create(@Valid @RequestBody Evento evento){
        return new ResponseEntity<Evento>(this.eventoService.save(evento), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Evento> update(@Valid @RequestBody Evento livro) {
        return new ResponseEntity<Evento>(this.eventoService.save(livro), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Evento não encontrado"),
            @ApiResponse(code = 200, message = "Evento localizado" )})
    public ResponseEntity<Evento> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<Evento>(this.eventoService.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Evento")), HttpStatus.OK);
    }
}
