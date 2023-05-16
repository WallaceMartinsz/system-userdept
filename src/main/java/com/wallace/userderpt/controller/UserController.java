package com.wallace.userderpt.controller;

import com.wallace.userderpt.entites.User;
import com.wallace.userderpt.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable int id){
        return userRepository.findById(id).get();
    }

    @GetMapping(value = "/departament/{id}")
    public List<User> findAllOfDepartament(@PathVariable int id) {
        List<User> users = userRepository.findAll();
        List<User> usersInDepartment = new ArrayList<>();
        for (User user : users) {
            if (user.getDepartament().getId() == id) {
                usersInDepartment.add(user);
            }
        }
        if (usersInDepartment.isEmpty()) {
            return null;
        } else {
            return usersInDepartment;
        }
    }

    @PostMapping
    public User insert(@RequestBody User user){
        return userRepository.save(user);
    }


}
