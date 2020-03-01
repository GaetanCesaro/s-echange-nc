package com.gegette.sechangenc.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.gegette.sechangenc.exception.EntityNotFoundException;
import com.gegette.sechangenc.model.Post;
import com.gegette.sechangenc.model.User;
import com.gegette.sechangenc.repository.PostRepository;
import com.gegette.sechangenc.repository.UserRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Query implements GraphQLQueryResolver {
    private PostRepository postRepository;
    private UserRepository userRepository;

    public Query(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public Iterable<Post> findAllPosts() {
        return postRepository.findAll();
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

    public long countPosts() {
        return postRepository.count();
    }
    public long countUsers() {
        return userRepository.count();
    }
}