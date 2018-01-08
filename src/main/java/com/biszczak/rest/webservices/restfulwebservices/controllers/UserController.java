package com.biszczak.rest.webservices.restfulwebservices.controllers;

import com.biszczak.rest.webservices.restfulwebservices.exception.EmptyUserException;
import com.biszczak.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import com.biszczak.rest.webservices.restfulwebservices.exception.UsersListEmptyException;
import com.biszczak.rest.webservices.restfulwebservices.models.User;
import com.biszczak.rest.webservices.restfulwebservices.models.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

// @ResponseBody annotation tells a controller that the object returned is automatically serialized into JSON and passed back into the HttpResponse object.
// @Controller - Indicates that an annotated class is a "Controller" (e.g. a web controller)

@RestController // add @ResponseBody and @Controller automatically
public class UserController {


    @Autowired
    private UserDaoService service;


    // GET /users
    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers(){
        List<User> users = service.findAll();
        if(users.isEmpty()) {
            throw new UsersListEmptyException("No users found at all!");    // throw exception, CustomizedResponseEntityExceptionHandler will auto handle it
        }
        return service.findAll();
    }

    // GET /users/{id}
    @GetMapping(path = "/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        User user = service.findOne(id);
        if(user == null) {
            throw new UserNotFoundException("User not found, id-" + id);
        }

        return user;
    }


    // POST /users
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user);
        // if created get /users/{id}
        if(user.getBrithDate() == null || user.getName() == null) {
            throw new EmptyUserException("POST user is empty!");
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }


    // DELETE /users/{id}
    @DeleteMapping("/users/{id}")
    public void deleteeUser(@PathVariable int id) {
        User user = service.deleteById(id);

        if(user == null) {
            throw new UserNotFoundException("User not found, id-" + id);
        }

    }

}
