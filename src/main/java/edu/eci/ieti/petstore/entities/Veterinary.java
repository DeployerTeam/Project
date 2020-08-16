package edu.eci.ieti.petstore.entities;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Veterinary {

    @Id
    private Long id;
}
