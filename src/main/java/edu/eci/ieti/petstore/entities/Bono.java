package edu.eci.ieti.petstore.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Bono {
    private int id;
    private String code;
    private Boolean redeemed;
    private String ownerEmail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public Boolean getRedeemed() {
        return redeemed;
    }

    public void setRedeemed(Boolean redeemed) {
        this.redeemed = redeemed;
    }

    @Override
    public String toString() {
        return "Bono{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", redeemed=" + redeemed +
                '}';
    }
}
