package br.com.codenation.user.mappers;

import br.com.codenation.user.dto.UserDTO;
import br.com.codenation.user.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO mapToDTO(User user);
}
