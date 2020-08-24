package br.com.codenation.service;

import br.com.codenation.entiy.Evento;
import br.com.codenation.entiy.Level;
import br.com.codenation.service.interfaces.EventoServiceInterface;

import java.util.List;
import java.util.Optional;

public class EventoService implements EventoServiceInterface {
    
    @Override
    public Optional<Evento> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Evento> findByDescricao(String descricao) {
        return null;
    }

    @Override
    public List<Evento> findByLog(String log) {
        return null;
    }

    @Override
    public List<Evento> findByOrigem(String origem) {
        return null;
    }

    @Override
    public List<Evento> findByQuantidade(Long quantidade) {
        return null;
    }

    @Override
    public List<Evento> findByLevel(Level level) {
        return null;
    }
}
