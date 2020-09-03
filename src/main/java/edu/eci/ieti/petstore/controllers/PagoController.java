package edu.eci.ieti.petstore.controllers;

import edu.eci.ieti.petstore.entities.Pago;
import edu.eci.ieti.petstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pay")
public class PagoController {

    @Autowired
    UserService userService;

    @PostMapping("/")
    public ResponseEntity<?> generarPago(@RequestBody Pago pago){
        Pago response = userService.pay(pago);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
