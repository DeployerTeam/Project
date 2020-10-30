package edu.eci.ieti.petstore.controllers;


import edu.eci.ieti.petstore.entities.FormAdopt;
import edu.eci.ieti.petstore.entities.User;
import edu.eci.ieti.petstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
        System.out.println(form.getIdPet());
        userService.addFormAdopt(form);
    }

    @PostMapping("/deleterequest")
    public void removeRequest(@RequestParam(value ="email") String email,@RequestParam(value="petId") String petId){
        System.out.println(email +  " "+ petId);
        userService.removeRequestAddopt(email,petId);
    }

    @GetMapping("/getforms")
    public List<FormAdopt> getForms(@RequestParam(value = "id") String id){
        return userService.getForms(id);
    }


}
