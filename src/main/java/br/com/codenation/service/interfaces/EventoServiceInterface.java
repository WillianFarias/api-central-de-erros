package br.com.codenation.service.interfaces;

import br.com.codenation.entiy.Evento;
import br.com.codenation.entiy.Level;

import java.util.List;
import java.util.Optional;

public interface EventoServiceInterface {

    Optional<Evento> findById(Long id);

    List<Evento> findByDescricao(String descricao);

    List<Evento> findByLog(String log);

    List<Evento> findByOrigem(String origem);

    List<Evento> findByQuantidade(Long quantidade);

    List<Evento> findByLevel(Level level);
}
