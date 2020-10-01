package edu.eci.ieti.petstore.services;

import edu.eci.ieti.petstore.entities.Proveedor;

import java.util.List;

public interface ProveedorService {

    /**
     * Update provider (alliance)
     * @param proveedor provider
     * @throws ExceptionServiciosAppet
     */
    void updateProveedor(String email, Proveedor proveedor) throws ExceptionServiciosAppet;

    /**
     * Get provider in system
     * @param email id provider
     * @return provider with id
     * @throws ExceptionServiciosAppet
     */
    Proveedor getProveedor(String email) throws ExceptionServiciosAppet;

    /**
     * Get list all providers in the system
     * @return all providers
     * @throws ExceptionServiciosAppet
     */
    List<Proveedor> getProveedores() throws  ExceptionServiciosAppet;

    /**
     * allow create provider
     * @param proveedor provider
     * @throws ExceptionServiciosAppet
     */
    void createProveedor(Proveedor proveedor) throws  ExceptionServiciosAppet;

    /**
     * delete provider exist
     * @param email id of provider to delete
     * @throws ExceptionServiciosAppet
     */
    void deleteProveedor(String email) throws ExceptionServiciosAppet;

}
