package edu.eci.ieti.petstore.services.impl;

import edu.eci.ieti.petstore.entities.Proveedor;
import edu.eci.ieti.petstore.repository.ProveedorRepository;
import edu.eci.ieti.petstore.services.ExceptionServiciosAppet;
import edu.eci.ieti.petstore.services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    ProveedorRepository proveedorRepository;

    @Override
    public List<Proveedor> getProveedores() throws ExceptionServiciosAppet {
        List<Proveedor> proveedores = proveedorRepository.findAll();
        return proveedores;
    }

    @Override
    public Proveedor getProveedor(String email) throws ExceptionServiciosAppet {
        Optional<Proveedor> prov = proveedorRepository.findById(email);
        if(prov.isPresent()){
            return prov.get();
        }else {
            throw new ExceptionServiciosAppet("No se ha encontrado el proveedor.");
        }
    }

    @Override
    public void createProveedor(Proveedor proveedor) throws ExceptionServiciosAppet {
        if(proveedorRepository.existsById(proveedor.getEmail())) {
            throw new ExceptionServiciosAppet("El proveedor ya existe.");
        }
        proveedorRepository.save(proveedor);
    }

    @Override
    public void updateProveedor(Proveedor proveedor) throws ExceptionServiciosAppet {
        Optional<Proveedor> prov = proveedorRepository.findById(proveedor.getEmail());
        if(prov.isPresent()){
            proveedorRepository.save(proveedor);
        }else{
            throw new ExceptionServiciosAppet("El proveedor no existe.");
        }
    }

    @Override
    public void deleteProveedor(String email) throws ExceptionServiciosAppet {
        Optional<Proveedor> prov = proveedorRepository.findById(email);
        if(!prov.equals(null)) {
            proveedorRepository.deleteById(email);
        }else {
            throw new ExceptionServiciosAppet("No se pudo eliminar el proveedor.");
        }
    }

}
