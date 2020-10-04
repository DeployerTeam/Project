package edu.eci.ieti.petstore.controllers;


import edu.eci.ieti.petstore.entities.Pet;
import edu.eci.ieti.petstore.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pet")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PetController {

    @Autowired
    PetService petService;

    @PostMapping("/add")
    public void addPet( @RequestBody Pet pet){
        petService.addPet(pet);
    }

    @GetMapping("/getpets")
    public List<Pet> getPets(){
        return petService.getAll();
    }
}
