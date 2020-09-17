package edu.eci.ieti.petstore.services.impl;

import edu.eci.ieti.petstore.repository.ProveedorRepository;
import edu.eci.ieti.petstore.repository.UserRepository;
import edu.eci.ieti.petstore.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthServiceImpl implements AuthService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProveedorRepository proveedorRepository;

    @Override
    public Boolean validateAccount(String email, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email,password));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        boolean isValid = false;
        if(userRepository.existsById(email)){

        }else if(proveedorRepository.existsById(email)){

        }
        return isValid;
    }
}
