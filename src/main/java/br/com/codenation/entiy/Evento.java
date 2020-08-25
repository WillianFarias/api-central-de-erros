package br.com.codenation.entiy;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @NotBlank
    @Column(name = "descricao_evento")
    @Size(max = 100)
    private String descricaoEvento;

    @NotNull
    @NotBlank
    @Column(name = "log_evento")
    @Size(max = 500)
    private String logEvento;

    @NotNull
    @NotBlank
    @Column
    @Size(max = 100)
    private String origem;

    @Column
    @NotNull
    private Long quantidade;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @CreatedDate
    private LocalDateTime data;

}
