package edu.eci.ieti.petstore.controllers;

import edu.eci.ieti.petstore.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("/signin")
    public String login(@RequestBody List<String> auths){
        authService.validateAccount(auths.get(0),auths.get(1));
        return "";
    }


}
