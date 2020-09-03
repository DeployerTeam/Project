package edu.eci.ieti.petstore.controllers;

import edu.eci.ieti.petstore.entities.User;
import edu.eci.ieti.petstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/create")
    public void createUser(@RequestBody ArrayList<String> user){
        //System.out.println(user.get(0) + " " + user.get(1) + " " +user.get(2) + " " + user.get(3));
        User newUser = new User(user.get(0), user.get(1), user.get(2), Integer.parseInt(user.get(3)));
        userService.create(newUser);
    }

}
