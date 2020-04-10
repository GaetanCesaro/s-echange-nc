package com.gegette.sechangenc.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.gegette.sechangenc.exception.EntityNotFoundException;
import com.gegette.sechangenc.model.Ad;
import com.gegette.sechangenc.model.User;
import com.gegette.sechangenc.repository.AdRepository;
import com.gegette.sechangenc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class UserQuery implements GraphQLQueryResolver {

    private UserRepository userRepository;

    @Autowired
    public UserQuery(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        throw new EntityNotFoundException("Utilisateur introuvable", id);
    }

    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Iterable<User> findUser(Long id, String firstName, String lastName){
        if (id != null) {
            Optional<User> optionalUser = userRepository.findById(id);
            if (optionalUser.isPresent()) {
                return Arrays.asList(optionalUser.get());
            }

            throw new EntityNotFoundException("Utilisateur introuvable", id);
        }

        if (firstName != null) {
            List<User> userList = userRepository.findByFirstName(firstName);
            if (!userList.isEmpty()) {
                return userList;
            }

            throw new EntityNotFoundException("Utilisateur introuvable", firstName);
        }

        if (lastName != null) {
            List<User> userList = userRepository.findByLastName(lastName);
            if (userList.isEmpty()) {
                return userList;
            }

            throw new EntityNotFoundException("Utilisateur introuvable", lastName);
        }

        throw new EntityNotFoundException("Utilisateur introuvable", 0L);
    }

    public long countUsers() {
        return userRepository.count();
    }
}