package edu.eci.ieti.petstore.services;

import edu.eci.ieti.petstore.entities.FormAdopt;
import edu.eci.ieti.petstore.entities.Pago;
import edu.eci.ieti.petstore.entities.User;

import java.util.List;

public interface UserService {

    /**
     * Method to add new user
     * @param user user
     * @return new user
     */
    User create(User user);

    /**
     * Method to know users in system
     * @param email  user id
     * @return boolean, true exist, false not exist
     */
    boolean existUser(String email);

    /**
     * Search and return user
     * @param email  user id
     * @return allow obtain user for email
     */
    User findUser(String email);

    /**
     * add request for adopt to user donor
     * @param formAdopt form to adopt
     */
    void addFormAdopt(FormAdopt formAdopt);

    List<FormAdopt> getForms(String email);

    Pago pay(Pago pago);

}
