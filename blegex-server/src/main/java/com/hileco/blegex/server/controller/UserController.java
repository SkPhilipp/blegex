package com.hileco.blegex.server.controller;

import com.hileco.blegex.server.model.User;
import com.hileco.blegex.server.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository repository;

    @Inject
    public UserController(final UserRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.POST)
    public User createUser(@RequestBody @Valid final User user) {
        return repository.save(user);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<User> getUsers() {
        return repository.findAll();
    }

}