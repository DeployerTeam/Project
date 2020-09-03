package edu.eci.ieti.petstore.services;

import edu.eci.ieti.petstore.entities.Proveedor;

import java.util.List;
import java.util.Optional;

public interface ProveedorService {

    void updateProveedor(Proveedor proveedor) throws ExceptionServiciosAppet;

    Proveedor getProveedor(String email) throws ExceptionServiciosAppet;

    List<Proveedor> getProveedores() throws  ExceptionServiciosAppet;

    void createProveedor(Proveedor proveedor) throws  ExceptionServiciosAppet;

    void deleteProveedor(String email) throws ExceptionServiciosAppet;

}
