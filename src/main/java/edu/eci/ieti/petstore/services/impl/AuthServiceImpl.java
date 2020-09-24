package edu.eci.ieti.petstore.services.impl;

import edu.eci.ieti.petstore.jwtSecurity.JwtResponse;
import edu.eci.ieti.petstore.jwtSecurity.JwtUtils;
import edu.eci.ieti.petstore.repository.ProveedorRepository;
import edu.eci.ieti.petstore.repository.UserRepository;
import edu.eci.ieti.petstore.services.AuthService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProveedorRepository proveedorRepository;

    @Autowired
    JwtUtils jwtUtils;

    @Override
    public ResponseEntity<?> validateAccount(String email, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email,password));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        System.out.println(jwt);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername()));
    }
}
