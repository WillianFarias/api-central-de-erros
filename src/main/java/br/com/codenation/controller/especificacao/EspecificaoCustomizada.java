package br.com.codenation.controller.especificacao;

import br.com.codenation.model.Evento;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@And({
        @Spec(path = "level", spec = Like.class),
        @Spec(path = "descricaoEvento", spec = Like.class),
        @Spec(path = "logEvento", spec = Like.class),
        @Spec(path = "origem", spec = Like.class),
        @Spec(path = "quantidade", spec = Equal.class),
        @Spec(path = "data", spec = Equal.class),
        @Spec(path = "data", params = {"createDateGt", "createDateLt"}, spec = Equal.class)
})
public interface EspecificaoCustomizada extends Specification<Evento> {
}
