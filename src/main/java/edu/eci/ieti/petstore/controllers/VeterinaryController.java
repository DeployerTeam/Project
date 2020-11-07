package edu.eci.ieti.petstore.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/veterinary")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VeterinaryController {

}
