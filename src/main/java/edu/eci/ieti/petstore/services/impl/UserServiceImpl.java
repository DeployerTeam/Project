package edu.eci.ieti.petstore.services.impl;

import edu.eci.ieti.petstore.entities.Pago;
import edu.eci.ieti.petstore.entities.User;
import edu.eci.ieti.petstore.repository.UserRepository;
import edu.eci.ieti.petstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;

@Service
public class UserServiceImpl implements UserService {

    private static String APIKEY = "";
    private static String MERCHANTID = "";

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


}
