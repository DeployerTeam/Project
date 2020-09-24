package edu.eci.ieti.petstore.services.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.eci.ieti.petstore.entities.Proveedor;
import edu.eci.ieti.petstore.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

public class UserDetailsImpl implements UserDetails {

    private String email;

    @JsonIgnore
    private String password;

    public UserDetailsImpl(String email, String password){
        this.email = email;
        this.password = password;
    }

    public static UserDetailsImpl build(Optional<User> usuario, Optional<Proveedor> proveedor){
        UserDetailsImpl userDetails = null;
        System.out.println(usuario + " "+ proveedor);
        if(usuario.isPresent()) {
            System.out.println("soy usuario");
            userDetails = new UserDetailsImpl(usuario.get().getEmail(),usuario.get().getPassword());
        }else if(proveedor.isPresent()){
            System.out.println("soy proveedor");
            userDetails = new UserDetailsImpl(proveedor.get().getEmail(),proveedor.get().getPassword());
        }
        return userDetails;

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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(email, user.email);
    }
}
