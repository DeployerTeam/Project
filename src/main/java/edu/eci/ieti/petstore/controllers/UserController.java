package edu.eci.ieti.petstore.controllers;


import edu.eci.ieti.petstore.entities.FormAdopt;
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
    public void createUser(@RequestBody User user){
        userService.create(user);
    }

    @PostMapping("/addform")
    public void addForm(@RequestBody FormAdopt form){
        System.out.println(form);
        User user = userService.findUser("andres@gmail.com"); //Correo mientras se implementa el poner en adopcion para probar
        user.addFormAdopt(form);
        userService.create(user);
    }

}
