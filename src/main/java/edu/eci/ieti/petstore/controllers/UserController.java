package edu.eci.ieti.petstore.controllers;


import edu.eci.ieti.petstore.entities.FormAdopt;
import edu.eci.ieti.petstore.entities.User;
import edu.eci.ieti.petstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/getforms")
    public List<FormAdopt> getForms(@RequestParam(value = "id") String id){
        return userService.getForms(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") String email){
        ResponseEntity response;
        try {
            response = new ResponseEntity<>(userService.getUser(email), HttpStatus.ACCEPTED);
        }catch (Exception e){
            e.printStackTrace();
            response = new ResponseEntity<>("No se encontró el usuario.",HttpStatus.NOT_FOUND);
        }
        return response;
    }

}
