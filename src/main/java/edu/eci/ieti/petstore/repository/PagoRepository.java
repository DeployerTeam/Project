package edu.eci.ieti.petstore.repository;

import edu.eci.ieti.petstore.entities.Pago;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PagoRepository extends MongoRepository<Pago,Integer > {


}
