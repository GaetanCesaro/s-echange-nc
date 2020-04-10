package com.gegette.sechangenc.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.gegette.sechangenc.exception.EntityNotFoundException;
import com.gegette.sechangenc.model.Ad;
import com.gegette.sechangenc.model.User;
import com.gegette.sechangenc.repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AdMutation implements GraphQLMutationResolver {

    private AdRepository adRepository;

    @Autowired
    public AdMutation(AdRepository adRepository) {
        this.adRepository = adRepository;
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