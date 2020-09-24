package edu.eci.ieti.petstore.services;

import org.springframework.http.ResponseEntity;

public interface AuthService {
    public ResponseEntity<?> validateAccount(String email, String password);
}
