package edu.eci.ieti.petstore.controllers;

import edu.eci.ieti.petstore.entities.Proveedor;
import edu.eci.ieti.petstore.services.ExceptionServiciosAppet;
import edu.eci.ieti.petstore.services.ProveedorService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/proveedores")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProveedorController {
    @Autowired
    ProveedorService proveedorService;

    @GetMapping
    public ResponseEntity<?> getProveedores(){
        try {
            return new ResponseEntity<>(proveedorService.getProveedores(), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("No se encontraron proveedores.", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProveedor(@PathVariable String email){
        ResponseEntity response;
        try {
            response = new ResponseEntity<>(proveedorService.getProveedor(email),HttpStatus.ACCEPTED);
        }catch (Exception e){
            e.printStackTrace();
            response = new ResponseEntity<>("No se encontró el proveedor.",HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProveedor(@RequestBody ArrayList<String> proveedor){
        ResponseEntity response;
        try{
            Proveedor newProveedor = new Proveedor(proveedor.get(0), proveedor.get(2), Integer.parseInt(proveedor.get(3)), proveedor.get(4));
            proveedorService.createProveedor(newProveedor);
            response = new ResponseEntity<>(HttpStatus.CREATED);
        }catch(ExceptionServiciosAppet e) {
            e.printStackTrace();
            response = new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProveedor(@RequestBody Proveedor proveedor) throws ExceptionServiciosAppet{
        try {
            proveedorService.updateProveedor(proveedor);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("No fue posible actualizar el proveedor.", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/proveedor/{id}")
    public ResponseEntity<?> deleteProveedor(@PathVariable String email) throws ExceptionServiciosAppet{
        try {
            proveedorService.deleteProveedor(email);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("No fue posible eliminar el proveedor.", HttpStatus.FORBIDDEN);
        }
    }

}