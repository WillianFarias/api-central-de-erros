package br.com.codenation.user.service.interfaces;

import br.com.codenation.user.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserServiceInterface {

    Optional<User> findById(Long id);
    Page<User> findAll(Pageable pageable);
    Optional<User> findByEmail(String email);
    User save(User user);
}
