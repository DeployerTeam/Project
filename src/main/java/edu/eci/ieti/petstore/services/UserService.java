package edu.eci.ieti.petstore.services;

import edu.eci.ieti.petstore.entities.User;

public interface UserService {

    User create(User user);

    boolean existUser(String email);

}
