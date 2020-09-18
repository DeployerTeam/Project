package edu.eci.ieti.petstore.services.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.eci.ieti.petstore.entities.Proveedor;
import edu.eci.ieti.petstore.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.Optional;

public class UserDetailsImpl implements UserDetails {

    private String email;

    @JsonIgnore
    private String password;

    public UserDetailsImpl(String email, String password){
        this.email = email;
        this.password = password;
    }

    public static UserDetailsImpl build(User usuario, Proveedor proveedor){
        if(usuario != null) {
            return new UserDetailsImpl(usuario.getEmail(),usuario.getPassword());
        }else if(proveedor != null){
            return new UserDetailsImpl(proveedor.getEmail(),proveedor.getPassword());
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
