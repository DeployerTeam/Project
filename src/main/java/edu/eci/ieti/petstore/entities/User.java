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
    private int age;
    private String city;
    private String address;
    private String gender;
    private String image;
    private List<FormAdopt> requestAdopt = new ArrayList<>();

    public void addFormAdopt(FormAdopt formAdopt){
        requestAdopt.add(formAdopt);
    }

    public void removeRequestAdopt(String email){
        for(FormAdopt formAdopt: requestAdopt){
            if(formAdopt.getEmail().equals(email)){
                requestAdopt.remove(formAdopt);
                break;
            }
        }
    }

    public String getEmail() { return email; }

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

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<FormAdopt> getRequestAdopt() {
        return requestAdopt;
    }

    public void setRequestAdopt(List<FormAdopt> requestAdopt) {
        this.requestAdopt = requestAdopt;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                ", image='" + image + '\'' +
                '}';
    }
}
