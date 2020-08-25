package br.com.codenation.repository;

import br.com.codenation.controller.especificacao.EspecificaoCustomizada;
import br.com.codenation.model.Evento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long>, JpaSpecificationExecutor<Evento> {
     //Page<Evento> findAll(EspecificaoCustomizada especificaoCustomizada, Pageable pageable);
}
