package edu.eci.ieti.petstore.controllers;


import edu.eci.ieti.petstore.entities.FormAdopt;
import edu.eci.ieti.petstore.entities.Proveedor;
import edu.eci.ieti.petstore.entities.User;
import edu.eci.ieti.petstore.services.ExceptionServiciosAppet;
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

    @PostMapping("/create")
    public void createUser(@RequestBody User user) throws ExceptionServiciosAppet {
        userService.create(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") String email, @RequestBody User user) throws ExceptionServiciosAppet{
        try {
            userService.updateUser(email, user);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("No fue posible actualizar el usuario.", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addform")
    public void addForm(@RequestBody FormAdopt form) throws ExceptionServiciosAppet {
        System.out.println(form.getIdPet());
        userService.addFormAdopt(form);
    }

    @PostMapping("/deleterequest")
    public void removeRequest(@RequestParam(value ="email") String email,@RequestParam(value="petId") String petId) throws ExceptionServiciosAppet {
        System.out.println(email +  " "+ petId);
        userService.removeRequestAddopt(email,petId);
    }

    @GetMapping("/getforms")
    public List<FormAdopt> getForms(@RequestParam(value = "id") String id) throws ExceptionServiciosAppet {
        return userService.getForms(id);
    }


}
