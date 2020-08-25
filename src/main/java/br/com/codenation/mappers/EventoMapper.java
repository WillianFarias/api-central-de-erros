package br.com.codenation.mappers;

import br.com.codenation.dto.EventoDTO;
import br.com.codenation.model.Evento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventoMapper {

    @Mappings({
            @Mapping(source = "id", target = "eventoId"),
            @Mapping(source = "level", target = "level"),
            @Mapping(source = "descricao", target = "descricao"),
            @Mapping(source = "origem", target = "origem"),
            @Mapping(source = "quantidade", target = "quantidade"),
            @Mapping(source = "data", target = "data", dateFormat = "yyyy-MM-dd HH:mm")
    })

    EventoDTO map(Evento evento);

    Page<EventoDTO> map(Page<Evento> eventos);

    //List<EventoDTO> map(Page<Evento> eventos);
}
