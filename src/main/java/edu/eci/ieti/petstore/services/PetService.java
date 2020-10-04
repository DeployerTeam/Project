package edu.eci.ieti.petstore.services;

import edu.eci.ieti.petstore.entities.Pet;

import java.util.List;

public interface PetService {

    Pet addPet(Pet pet);

    List<Pet> getAll();
}
