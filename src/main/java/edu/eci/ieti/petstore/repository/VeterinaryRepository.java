package edu.eci.ieti.petstore.repository;


import edu.eci.ieti.petstore.entities.Veterinary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinaryRepository extends MongoRepository<Veterinary, Long> {


}
