package edu.eci.ieti.petstore.services.impl;

import edu.eci.ieti.petstore.entities.Bono;
import edu.eci.ieti.petstore.repository.BonoRepository;
import edu.eci.ieti.petstore.services.BonoService;
import edu.eci.ieti.petstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BonoServiceImpl implements BonoService {

    @Autowired
    BonoRepository bonoRepository;

    @Autowired
    UserService userService;

    @Override
    public void generate(Bono bono) {
        int id = getBonos().size() + 1;
        String code = "";
        for(int x = 0; x < 10; x++){
            int n1 = (int) (Math.random() * (58 - 48)) + 48;
            int n2 = (int) (Math.random() * (91 - 65)) + 65;
            int n3 = (int) (Math.random() * (123 - 97)) + 97;
            code = code + (char) n1;
            code = code + (char) n2;
            code = code + (char) n3;
        }
        bono.setId(id);
        bono.setCode(code);
        save(bono);
    }

    @Override
    public Bono save(Bono bono) {
        return bonoRepository.save(bono);
    }

    @Override
    public List<Bono> getBonos() {
        return bonoRepository.findAll();
    }

    @Override
    public List<Bono> findBonoByOwnerEmail(String email) {
        return bonoRepository.findByOwnerEmail(email);
    }

    @Override
    public boolean redeem(String userEmail, String code) {
        boolean accepted = false;
        List<Bono> bonos = bonoRepository.findByOwnerEmail(userEmail);
        for(Bono bono : bonos){
            if(bono.getCode().equals(code) && bono.getRedeemed() == false){
                accepted = true;
                bono.setRedeemed(true);
                save(bono);
            }
        }
        return accepted;
    }


}
