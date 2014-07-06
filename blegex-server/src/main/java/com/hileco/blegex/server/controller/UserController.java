package com.hileco.blegex.server.controller;

import com.hileco.blegex.server.model.User;
import com.hileco.blegex.server.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.validation.Valid;

@RestController
@RequestMapping("/services/users")
public class UserController {

    private final UserRepository userRepository;

    @Inject
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    public User createUser(@RequestBody @Valid final User user) {
        return userRepository.save(user);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<User> getUsers() {
        //        User user = new User();
        //        user.setUsername("sanic");
        //        user.setPassword("g0f4st");
        //        userRepository.save(user);
        return userRepository.findAll();
    }

}