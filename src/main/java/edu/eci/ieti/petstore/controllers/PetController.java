package edu.eci.ieti.petstore.controllers;


import edu.eci.ieti.petstore.entities.Pet;
import edu.eci.ieti.petstore.entities.User;
import edu.eci.ieti.petstore.services.PetService;
import edu.eci.ieti.petstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pet")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PetController {

    @Autowired
    PetService petService;

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public void addPet( @RequestBody Pet pet){
        petService.addPet(pet);
    }

    @GetMapping("/getpets")
    public List<Pet> getPets(){
        return petService.getAll();
    }

    @DeleteMapping("/delete")
    public void approveRequest(@RequestParam (value = "petId") String petId, @RequestParam(value="email") String email){
        System.out.println(petId);
        String emailDonor = petService.getDonorPet(Long.parseLong(petId));
        User user = userService.findUser(emailDonor);
        user.removeRequestAdopt(email);
        userService.create(user);
        petService.removePetById(Long.parseLong(petId));
    }
}
