package br.com.codenation.log.service.interfaces;

import br.com.codenation.log.controller.especificacao.EspecificaoCustomizada;
import br.com.codenation.log.model.Evento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface EventoServiceInterface {

    Optional<Evento> findById(Long id);

    Page<Evento> findAll(EspecificaoCustomizada especificaoCustomizada, Pageable pageable);

    Evento save(Evento evento);

    void deleteById(Long id);

}
