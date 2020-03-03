package com.gegette.sechangenc.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.gegette.sechangenc.exception.EntityNotFoundException;
import com.gegette.sechangenc.model.Post;
import com.gegette.sechangenc.model.User;
import com.gegette.sechangenc.repository.PostRepository;
import com.gegette.sechangenc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

    private UserRepository userRepository;
    private PostRepository postRepository;

    @Autowired
    public Mutation(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public User newUser(String email, String firstName, String lastName) {
        User user = new User();
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);

        userRepository.save(user);

        return user;
    }

    public Post newPost(String title, String description, Integer price, Long ownerId) {
        Post post = new Post();
        post.setOwner(new User(ownerId));
        post.setTitle(title);
        post.setDescription(description);
        post.setPrice(price != null ? price : 0);

        postRepository.save(post);

        return post;
    }

    public boolean deletePost(Long id) {
        postRepository.deleteById(id);
        return true;
    }

    public Post updatePostPrice(Integer price, Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            post.setPrice(price != null ? price : 0);

            postRepository.save(post);

            return post;
        }

        throw new EntityNotFoundException("Post introuvable", id);
    }
}