package br.com.codenation.user.controller;

import br.com.codenation.log.controller.advice.ResourceNotFoundException;
import br.com.codenation.user.dto.UserDTO;
import br.com.codenation.user.mappers.UserMapper;
import br.com.codenation.user.model.User;
import br.com.codenation.user.service.interfaces.UserServiceInterface;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UserController {

    @Autowired
    private UserServiceInterface userService;

    private final UserMapper userMapper;

    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @PostMapping
    @ApiOperation("Cria novo usuário")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Usuário criado com sucesso")})
    public ResponseEntity<User> create(@Valid @RequestBody User user) {
        return new ResponseEntity<User>(this.userService.save(user), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<User> update(@Valid @RequestBody User user) {
        return new ResponseEntity<User>(this.userService.save(user), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Usuário não encontrado"),
            @ApiResponse(code = 200, message = "Usuário localizado")})
    public ResponseEntity<User> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<User>(this.userService.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("User")), HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation("Lista todos os usuários")
    public ResponseEntity<Page<UserDTO>> findAll(Pageable pageable) {
        Page<User> usuarios = userService.findAll(pageable);
        Page<UserDTO> userDTO = usuarios.map(userMapper::mapToDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
}
