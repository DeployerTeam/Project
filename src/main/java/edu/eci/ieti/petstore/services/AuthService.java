package edu.eci.ieti.petstore.services;

import org.springframework.http.ResponseEntity;

public interface AuthService {
    /**
     * Allow validate account in system
     * @param email user id
     * @param password password user
     * @return token, email and type (user or alliance) in Json File
     */
     ResponseEntity<?> validateAccount(String email, String password);
}
