package com.gegette.sechangenc.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.gegette.sechangenc.exception.EntityNotFoundException;
import com.gegette.sechangenc.model.Ad;
import com.gegette.sechangenc.model.User;
import com.gegette.sechangenc.repository.AdRepository;
import com.gegette.sechangenc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

    private UserRepository userRepository;
    private AdRepository adRepository;

    @Autowired
    public Mutation(UserRepository userRepository, AdRepository adRepository) {
        this.userRepository = userRepository;
        this.adRepository = adRepository;
    }

    public User newUser(String email, String firstName, String lastName) {
        User user = new User();
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);

        userRepository.save(user);

        return user;
    }

    public Ad newAd(String title, String description, Integer price, String imageUrl, String category, Long ownerId) {
        Ad ad = new Ad();
        ad.setOwner(new User(ownerId));
        ad.setTitle(title);
        ad.setDescription(description);
        ad.setPrice(price != null ? price : 0);
        ad.setImageUrl(imageUrl);
        ad.setCategory(category);

        adRepository.save(ad);

        return ad;
    }

    public boolean deleteAd(Long id) {
        adRepository.deleteById(id);
        return true;
    }

    public Ad updateAdPrice(Integer price, Long id) {
        Optional<Ad> optionalAd = adRepository.findById(id);
        if (optionalAd.isPresent()) {
            Ad ad = optionalAd.get();
            ad.setPrice(price != null ? price : 0);

            adRepository.save(ad);

            return ad;
        }

        throw new EntityNotFoundException("Ad introuvable", id);
    }
}