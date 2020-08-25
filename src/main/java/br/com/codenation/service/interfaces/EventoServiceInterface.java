package br.com.codenation.service.interfaces;

import br.com.codenation.entiy.Evento;
import br.com.codenation.entiy.Level;

import java.util.List;
import java.util.Optional;

public interface EventoServiceInterface extends ServiceInterface<Evento>{

    Optional<Evento> findById(Long id);

    List<Evento> findAll();

}
