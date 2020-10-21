package edu.eci.ieti.petstore.repository;

import edu.eci.ieti.petstore.entities.Bono;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface BonoRepository extends MongoRepository<Bono,Long> {

    List<Bono> findByOwnerEmail(String email);

}
