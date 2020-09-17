package edu.eci.ieti.petstore.services;

public interface AuthService {
    public Boolean validateAccount(String email, String password);
}
