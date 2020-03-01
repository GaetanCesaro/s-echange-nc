package com.gegette.sechangenc.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.gegette.sechangenc.model.Post;
import com.gegette.sechangenc.model.User;
import com.gegette.sechangenc.repository.PostRepository;
import com.gegette.sechangenc.repository.UserRepository;

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

    public long countPosts() {
        return postRepository.count();
    }
    public long countUsers() {
        return userRepository.count();
    }
}