package org.example.uberauthservice.helpers;

import org.example.uberproject.models.Passenger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

// Why we need this class?
// Because spring security works on UserDetails polymorphic type of auth
public class AuthPassengerDetails extends Passenger implements UserDetails {
    private String username;
    private String password;

    public AuthPassengerDetails(Passenger passenger) {
        this.username = passenger.getEmail();
        this.password = passenger.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null; // we are not implementing roles and authorities for now
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    // Below set of method are not much of a concern

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
