package br.com.codenation.log.mappers;

import br.com.codenation.log.dto.EventoDTO;
import br.com.codenation.log.model.Evento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventoMapper {

    EventoDTO mapToDTO(Evento evento);
}
