package com.gegette.sechangenc.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.gegette.sechangenc.exception.EntityNotFoundException;
import com.gegette.sechangenc.model.Post;
import com.gegette.sechangenc.model.User;
import com.gegette.sechangenc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PostResolver implements GraphQLResolver<Post> {

    private UserRepository userRepository;

    @Autowired
    public PostResolver(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getOwner(Post post) {
        Optional<User> optionalUser = userRepository.findById(post.getOwner().getId());
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        throw new EntityNotFoundException("Utilisateur introuvable", post.getOwner().getId());
    }
}