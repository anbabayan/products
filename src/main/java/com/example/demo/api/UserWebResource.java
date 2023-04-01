package com.example.demo.api;

import com.example.demo.components.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Web resource to manage the users.
 */
@RestController
@RequestMapping(path = "api/v1/users")
@CrossOrigin
public class UserWebResource {
    private UserService userService;

    @Autowired
    UserWebResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @Cacheable("users")
    public List<User> getUsers() {
        return userService.listAll();
    }

    @PostMapping("/save")
    @CachePut(value = "users",key = "#user.id")
    public ResponseEntity<String> save(@RequestBody User user) {
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Cacheable(value = "users", key = "#id")
    public ResponseEntity<User> getById(@PathVariable int id) {
        return userService.getById(id);
    }

    @DeleteMapping("/delete")
    @CacheEvict(value = "users", allEntries = true, key = "#id")
    public ResponseEntity<String> delete(@RequestParam int id) {
        return userService.delete(id);
    }
}
