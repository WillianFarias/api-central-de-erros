package br.com.codenation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventoDTO {

    private Long eventoId;
    private String level;
    private String descricao;
    private String origem;
    private Long quantidade;
    private String data;
}
