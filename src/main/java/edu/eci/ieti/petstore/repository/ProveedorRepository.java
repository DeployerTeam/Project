package edu.eci.ieti.petstore.repository;

import edu.eci.ieti.petstore.entities.Proveedor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProveedorRepository extends MongoRepository<Proveedor, String> {

    Proveedor save(Proveedor proveedor);

    Optional<Proveedor> findById(String email);

    void deleteById(String email);

    List<Proveedor> findAll();

}
