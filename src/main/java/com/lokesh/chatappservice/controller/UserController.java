package com.lokesh.chatappservice.controller;

import com.lokesh.chatappservice.model.User;
import com.lokesh.chatappservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping(value = "/{id}")
    public Mono<ResponseEntity<User>> getUserById(@PathVariable("id") String id) {
        return this.userRepository.findById(id)
                .map(savedUser->ResponseEntity.ok(savedUser))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
    @PostMapping()
    public Mono<User> saveUser(@RequestBody User user) {
        log.info("user added successfully...");
        return this.userRepository.save(user);
    }
}
