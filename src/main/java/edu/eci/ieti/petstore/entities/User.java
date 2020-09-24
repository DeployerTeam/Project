package edu.eci.ieti.petstore.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class User {

    @Id
    private String email;

    private String password;
    private String name;
    private int phone;
    private List<FormAdopt> requestAdopt = new ArrayList<>();

    public void addFormAdopt(FormAdopt formAdopt){
        requestAdopt.add(formAdopt);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public List<FormAdopt> getRequestAdopt() {
        return requestAdopt;
    }

    public void setRequestAdopt(List<FormAdopt> requestAdopt) {
        this.requestAdopt = requestAdopt;
    }
}
