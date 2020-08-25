package br.com.codenation.controller;

import br.com.codenation.model.Evento;
import br.com.codenation.service.interfaces.EventoServiceInterface;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    
}
