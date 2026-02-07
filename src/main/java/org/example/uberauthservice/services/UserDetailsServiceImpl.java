package org.example.uberauthservice.services;

import org.example.uberauthservice.helpers.AuthPassengerDetails;
import org.example.uberauthservice.repositories.PassengerRepository;
import org.example.uberproject.models.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

// This class will implement the UserDetailsService interface to load user-specific data during authentication.
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        Optional<Passenger> passenger = passengerRepository.findPassengerByEmail(email); // this email is the unique identifier
        if(passenger.isPresent()) {
            return new AuthPassengerDetails(passenger.get());
        }
        else {
            throw new UsernameNotFoundException("Cannot find the Passenger by the given Email");
        }
    }
}
