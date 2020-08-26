package br.com.codenation.mappers;

import br.com.codenation.dto.EventoDTO;
import br.com.codenation.model.Evento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EventoMapper {

    EventoDTO mapToDTO(Evento evento);

}
