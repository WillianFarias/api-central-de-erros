package br.com.codenation.service.interfaces;

import br.com.codenation.model.Evento;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EventoServiceInterface{

    Optional<Evento> findById(Long id);

    List<Evento> findAll(Pageable pageable);

    Evento save(Evento evento);

    void deleteById(Long id);

}
