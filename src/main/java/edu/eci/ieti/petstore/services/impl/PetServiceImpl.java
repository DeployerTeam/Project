package edu.eci.ieti.petstore.services.impl;

import edu.eci.ieti.petstore.entities.Pet;
import edu.eci.ieti.petstore.repository.PetRepository;
import edu.eci.ieti.petstore.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    PetRepository petRepository;


    @Override
    public Pet addPet(Pet pet) {
        int id = getAll().size() + 1;
        pet.setId(id);
        return petRepository.save(pet);
    }

    @Override
    public List<Pet> getAll() {
        return petRepository.findAll();
    }

    @Override
    public String getDonorPet(Long id) {
        return petRepository.getPetById(id).getUserDonor();
    }

    @Override
    public void removePetById(Long id) {
        System.out.println(petRepository.getPetById(id));
        petRepository.removePetById(id);
    }
}
