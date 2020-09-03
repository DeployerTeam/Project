package edu.eci.ieti.petstore.services.impl;

import edu.eci.ieti.petstore.entities.User;
import edu.eci.ieti.petstore.repository.UserRepository;
import edu.eci.ieti.petstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean existUser(String email) {
        return userRepository.existsById(email);
    }


}
