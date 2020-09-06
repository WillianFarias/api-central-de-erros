package br.com.codenation.user.config;

import br.com.codenation.user.model.Role;
import br.com.codenation.user.model.User;
import br.com.codenation.user.repository.RoleRepository;
import br.com.codenation.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;

public class DataInitializr implements ApplicationListener<ContextRefreshedEvent> {

    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_CLIENT = "ROLE_CLIENT";

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        List<User> users = userRepository.findAll();

        if (users.isEmpty()){
            createUser("Admin", "admin", passwordEncoder.encode("123456"), ROLE_ADMIN);
            createUser("Cliente", "cliente", passwordEncoder.encode("123456"), ROLE_CLIENT);
        }
    }

    private void createUser(String name, String email, String password, String roleName) {
        Role role = new Role(roleName);

        this.roleRepository.save(role);
        User user = new User(name, email, password, Arrays.asList(role));
        userRepository.save(user);
    }
}
