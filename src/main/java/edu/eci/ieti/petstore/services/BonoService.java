package edu.eci.ieti.petstore.services;

import edu.eci.ieti.petstore.entities.Bono;

import java.util.List;
import java.util.Optional;

public interface BonoService {

    void generate(Bono bono);

    Bono save(Bono bono);

    List<Bono> getBonos();

    List<Bono> findBonoByOwnerEmail(String email);
}
