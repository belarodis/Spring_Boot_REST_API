package com.belarodis.rest.webservices.restful_web_services.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    private UserDaoService service;

    public UserResource(UserDaoService service) {
        this.service = service;
    }

    //GET
    @GetMapping({"/users", "/users/"})
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    @GetMapping({"/users/{id}", "/users/{id}/"})
    public User retrieveUser(@PathVariable int id) {
        User user = service.findOne(id);

        if (user==null) {
            throw new UserNotFoundException("id: "+ id);
        }

        return service.findOne(id);
    }

    //POST
    @PostMapping({ "/users", "/users/" })
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build(); //retorna código que indica q foi criado (sucesso)
    }
    
    //DELETE
    @DeleteMapping({"/users/{id}", "/users/{id}/"})
    public void deleteUser(@PathVariable int id) {
        service.deleteById(id);
    }
}
