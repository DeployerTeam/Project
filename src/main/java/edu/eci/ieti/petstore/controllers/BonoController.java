package edu.eci.ieti.petstore.controllers;

import edu.eci.ieti.petstore.entities.Bono;
import edu.eci.ieti.petstore.services.BonoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/bono")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BonoController {

    @Autowired
    BonoService bonoService;

    @PostMapping("/generate")
    public ResponseEntity<?> bonoGenerator(@RequestBody Bono bono){
        try{
            bonoService.generate(bono);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/getmybonos")
    public ResponseEntity getMyBonos(@RequestParam (value = "user") String user){
        try{
            List<Bono> response = bonoService.findBonoByOwnerEmail(user);
            return new ResponseEntity<>(response,HttpStatus.OK);

        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
