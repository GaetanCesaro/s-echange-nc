package com.gegette.sechangenc.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.gegette.sechangenc.exception.EntityNotFoundException;
import com.gegette.sechangenc.model.Ad;
import com.gegette.sechangenc.model.User;
import com.gegette.sechangenc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AdResolver implements GraphQLResolver<Ad> {

    private UserRepository userRepository;

    @Autowired
    public AdResolver(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getOwner(Ad ad) {
        Optional<User> optionalUser = userRepository.findById(ad.getOwner().getId());
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        throw new EntityNotFoundException("Utilisateur introuvable", ad.getOwner().getId());
    }
}