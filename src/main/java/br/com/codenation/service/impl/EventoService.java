package br.com.codenation.service.impl;

import br.com.codenation.entiy.Evento;
import br.com.codenation.repository.EventoRepository;
import br.com.codenation.service.interfaces.EventoServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EventoService implements EventoServiceInterface {

    @Autowired
    private EventoRepository eventoRepository;


    @Override
    public Optional<Evento> findById(Long id) {
        return eventoRepository.findById(id);
    }

    @Override
    public List<Evento> findAll() {
        return eventoRepository.findAll();
    }

    @Override
    @Transactional
    public Evento save(Evento evento) {
        return eventoRepository.save(evento);
    }
}
