package br.com.codenation.entiy;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.persistence.EntityListeners;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@EntityListeners(AuditingEntityListener.class)
public class Level {

    @Column
    @NotNull
    @Size(max = 100)
    private String error;

    @Column
    @NotNull
    @Size(max = 100)
    private String warning;

    @Column
    @NotNull
    @Size(max = 100)
    private String info;

}
