package br.com.codenation.user.service.interfaces;

import br.com.codenation.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {

    Optional<User> findById(Long id);
    List<User> findAll();
    Optional<User> findByEmail(String email);
    User save(User user);
}
