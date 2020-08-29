package br.com.codenation.log.service.impl;

import br.com.codenation.log.controller.especificacao.EspecificaoCustomizada;
import br.com.codenation.log.model.Evento;
import br.com.codenation.log.repository.EventoRepository;
import br.com.codenation.log.service.interfaces.EventoServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EventoServiceImpl implements EventoServiceInterface {

    @Autowired
    private EventoRepository eventoRepository;


    @Override
    public Optional<Evento> findById(Long id) {
        return this.eventoRepository.findById(id);
    }

    @Override
    public Page<Evento> findAll(EspecificaoCustomizada especificaoCustomizada, Pageable pageable) {
        return this.eventoRepository.findAll(especificaoCustomizada, pageable);
    }

    @Override
    public Evento save(Evento evento) {
        return this.eventoRepository.save(evento);
    }

    @Override
    public void deleteById(Long id) {
        this.eventoRepository.deleteById(id);
    }
}
