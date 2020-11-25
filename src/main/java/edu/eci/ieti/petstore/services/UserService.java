package edu.eci.ieti.petstore.services;

import edu.eci.ieti.petstore.entities.*;

import java.util.List;

public interface UserService {

    /**
     * Search and return user
     * @param email  user id
     * @return allow obtain user for email
     * @throws ExceptionServiciosAppet
     */
    User getUser(String email) throws ExceptionServiciosAppet;

    /**
     * Method to add new user
     * @param user user
     * @return new user
     */
    User create(User user) throws ExceptionServiciosAppet;

    /**
     * Update user information
     * @param user provider
     * @throws ExceptionServiciosAppet
     */
    void updateUser(String email, User user) throws ExceptionServiciosAppet;

    /**
     * Method to know users in system
     * @param email  user id
     * @return boolean, true exist, false not exist
     */
    boolean existUser(String email);

    /**
     * add request for adopt to user donor
     * @param formAdopt form to adopt
     */
    void addFormAdopt(FormAdopt formAdopt) throws ExceptionServiciosAppet;

    void removeRequestAddopt(String email, String petId) throws ExceptionServiciosAppet;

    List<FormAdopt> getForms(String email) throws ExceptionServiciosAppet;

    Pago pay(Pago pago);



}
