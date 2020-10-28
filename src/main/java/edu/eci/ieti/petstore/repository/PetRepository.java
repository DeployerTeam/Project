package edu.eci.ieti.petstore.repository;

import edu.eci.ieti.petstore.entities.Pet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends MongoRepository<Pet, Long> {

    Pet getPetById(Long id);

    void removePetBy(Long id);

}