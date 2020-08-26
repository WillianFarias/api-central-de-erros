package br.com.codenation.mappers;

import br.com.codenation.dto.EventoDTO;
import br.com.codenation.model.Evento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EventoMapper {

    //@Mapping(source = "id", target = "eventoId")
//    @Mapping(source = "level", target = "level")
    //@Mapping(source = "descricaoEvento", target = "descricao")
//    @Mapping(source = "origem", target = "origem")
//    @Mapping(source = "quantidade", target = "quantidade")

    @Mapping(source = "data", target = "data", dateFormat = "yyyy-MM-dd")
    EventoDTO mapToDTO(Evento evento);

}
