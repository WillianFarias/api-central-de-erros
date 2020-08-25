package br.com.codenation.service.impl;

import br.com.codenation.controller.especificacao.EspecificaoCustomizada;
import br.com.codenation.model.Evento;
import br.com.codenation.repository.EventoRepository;
import br.com.codenation.service.interfaces.EventoServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
    public List<Evento> findAll(EspecificaoCustomizada especificaoCustomizada, Pageable pageable) {
        return this.eventoRepository.findAll(especificaoCustomizada, pageable).getContent();
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
