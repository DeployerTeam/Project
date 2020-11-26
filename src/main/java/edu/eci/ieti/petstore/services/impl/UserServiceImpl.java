package edu.eci.ieti.petstore.services.impl;

import edu.eci.ieti.petstore.entities.*;
import edu.eci.ieti.petstore.repository.ProveedorRepository;
import edu.eci.ieti.petstore.repository.UserRepository;
import edu.eci.ieti.petstore.services.ExceptionServiciosAppet;
import edu.eci.ieti.petstore.services.PetService;
import edu.eci.ieti.petstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private static String APIKEY = "";
    private static String MERCHANTID = "";
    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    PetService petService;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    ProveedorRepository proveedorRepository;

    @Override
    public User create(User user) throws ExceptionServiciosAppet {
        if(user.getPassword().length() < 20) {
            user.setPassword(encoder.encode(user.getPassword()));
        }

        return userRepository.save(user);
    }

    @Override
    public void updateUser(String email, User user) throws ExceptionServiciosAppet {
        boolean existe = userRepository.existsById(email);
        if(existe){
            userRepository.save(user);
        }else{
            throw new ExceptionServiciosAppet("El usuario no existe.");
        }
    }

    @Override
    public boolean existUser(String email) {
        return userRepository.existsById(email);
    }

    @Override
    public User getUser(String email) throws ExceptionServiciosAppet {
        Optional<User> user = userRepository.findById(email);
        if(user.isPresent()){
            return user.get();
        }else {
            throw new ExceptionServiciosAppet("No se ha encontrado el usuario.");
        }
    }

    @Override
    public void addFormAdopt(FormAdopt formAdopt) throws ExceptionServiciosAppet {
        String donorEmail = petService.getDonorPet(Long.parseLong(formAdopt.getIdPet()));
        User user = getUser(donorEmail); //Correo mientras se implementa el poner en adopcion para probar

        user.addFormAdopt(formAdopt);
        create(user);
    }

    @Override
    public void removeRequestAddopt(String email, String petId) throws ExceptionServiciosAppet {
        String emailDonor = petService.getDonorPet(Long.parseLong(petId));
        User user = getUser(emailDonor);
        user.removeRequestAdopt(email);
        create(user);
    }

    @Override
    public List<FormAdopt> getForms(String email) throws ExceptionServiciosAppet {
        return getUser(email).getRequestAdopt();
    }

    @Override
    public Pago pay(Pago pago) {
        Calendar calendar = Calendar.getInstance();
        String referenceCode = getMD5(calendar.getCalendarType() + pago.getBuyerEmail() + pago.getBuyerFullName());
        pago.setReferenceCode(referenceCode);
        pago.setSignature(getMD5(APIKEY + "~" + MERCHANTID + "~" + referenceCode + "~" + pago.getAmount() + "~" + pago.getCurrency()));
        return pago;
    }

    private static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findById(email);
        Optional<Proveedor> prov = proveedorRepository.findById(email);
        if(user == null && prov == null) {
            logger.error("Error en el login: No existe el usuario '"+email+"' en el sistema!");
            throw new UsernameNotFoundException("Error en el login: No existe el usuario '"+email+"' en el sistema!");
        }

        return UserDetailsImpl.build(user,prov);
    }
}
