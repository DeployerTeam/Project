package edu.eci.ieti.petstore.repository;

import edu.eci.ieti.petstore.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    boolean existsById(String email);

    Optional<User> findById(String email);

}
