package app.talkers.users.controller;

import app.talkers.users.converter.impl.UserConverter;
import app.talkers.users.exception.UserException;
import app.talkers.users.model.dao.User;
import app.talkers.users.model.dto.UserDTO;
import app.talkers.users.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserConverter userConverter;

    @GetMapping
    private ResponseEntity<List<UserDTO>> getUsers(
            @RequestParam(value = "email", required = false) Optional<String> emailOptional) throws UserException {
        List<User> users;
        if (emailOptional.isPresent()) {
            log.info("GET /users?email={}", emailOptional.get());
            users = this.userService.findByEmail(emailOptional.get());
        } else {
            log.info("GET /users");
            users = this.userService.getAll();
        }
        List<UserDTO> userDTOs = this.userConverter.dtosFromEntities(users);
        return new ResponseEntity<>(userDTOs, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    private ResponseEntity<UserDTO> getUsersById(@PathVariable Integer id) throws UserException {
        log.info("GET /users/{}", id);
        User user = this.userService.getById(id);
        UserDTO userDTO = this.userConverter.dtoFromEntity(user);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<UserDTO> postUsers(@RequestBody UserDTO userDTO) throws UserException {
        log.info("POST /users");
        User user = this.userConverter.entityFromDto(userDTO);
        user = this.userService.create(user);
        userDTO = this.userConverter.dtoFromEntity(user);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }
}
