package com.gegette.sechangenc.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.gegette.sechangenc.exception.EntityNotFoundException;
import com.gegette.sechangenc.model.Ad;
import com.gegette.sechangenc.repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AdQuery implements GraphQLQueryResolver {
    private AdRepository adRepository;

    @Autowired
    public AdQuery(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    public Ad getAd(Long id) {
        Optional<Ad> optionalAd = adRepository.findById(id);
        if (optionalAd.isPresent()) {
            return optionalAd.get();
        }
        throw new EntityNotFoundException("Annonce introuvable", id);
    }

    public Iterable<Ad> findAllAds() {
        return adRepository.findAll();
    }

    public long countAds() {
        return adRepository.count();
    }

}
