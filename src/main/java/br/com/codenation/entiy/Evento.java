package br.com.codenation.entiy;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@SecondaryTable(name = "leval", pkJoinColumns = @PrimaryKeyJoinColumn(name = "evento_id"))
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @JsonIgnore
    private Level level;

    @Column
    @NotNull
    @Size(max = 100)
    private String descricao;

    @Column
    @NotNull
    @Size(max = 500)
    private String log;

    @Column
    @NotNull
    @Size(max = 100)
    private String origem;

    @Column
    @NotNull
    private Long quantidade;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @CreatedDate
    private LocalDateTime data;

}
