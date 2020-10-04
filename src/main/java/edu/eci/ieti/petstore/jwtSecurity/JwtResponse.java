package edu.eci.ieti.petstore.jwtSecurity;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String email;
    private Boolean isSupplier;

    public JwtResponse(String accessToken, String email, Boolean isSupplier) {
        this.token = accessToken;
        this.email = email;
        this.isSupplier = isSupplier;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsSupplier() {
        return isSupplier;
    }

    public void setIsSupplier(Boolean isSupplier) {
        this.isSupplier = isSupplier;
    }
}
