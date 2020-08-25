package br.com.codenation.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Level level;

    @NotNull
    @NotBlank(message = "Campo obrigatório")
    @Column(name = "descricao_evento")
    @Size(max = 100)
    private String descricaoEvento;

    @NotNull
    @NotBlank(message = "Campo obrigatório")
    @Column(name = "log_evento")
    @Size(max = 500)
    private String logEvento;

    @NotNull
    @NotBlank(message = "Campo obrigatório")
    @Column
    @Size(max = 100)
    private String origem;

    @Min(1)
    @Column
    @NotNull
    private Long quantidade;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @CreatedDate
    private LocalDateTime data;

}
