package com.gegette.sechangenc;

import com.gegette.sechangenc.exception.GraphQLErrorAdapter;
import com.gegette.sechangenc.repository.PostRepository;
import com.gegette.sechangenc.repository.UserRepository;
import com.gegette.sechangenc.resolver.Mutation;
import com.gegette.sechangenc.resolver.PostResolver;
import com.gegette.sechangenc.resolver.Query;
import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.kickstart.execution.error.GraphQLErrorHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class SEchangeNcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SEchangeNcApplication.class, args);
	}

    @Bean
    public PostResolver postResolver(UserRepository userRepository) {
        return new PostResolver(userRepository);
    }

    @Bean
    public Query query(UserRepository userRepository, PostRepository postRepository) {
        return new Query(userRepository, postRepository);
    }

    @Bean
    public Mutation mutation(UserRepository userRepository, PostRepository postRepository) {
        return new Mutation(userRepository, postRepository);
    }

	@Bean
	public GraphQLErrorHandler errorHandler() {
		return new GraphQLErrorHandler() {
			@Override
			public List<GraphQLError> processErrors(List<GraphQLError> errors) {
				List<GraphQLError> clientErrors = errors.stream()
						.filter(this::isClientError)
						.collect(Collectors.toList());

				List<GraphQLError> serverErrors = errors.stream()
						.filter(e -> !isClientError(e))
						.map(GraphQLErrorAdapter::new)
						.collect(Collectors.toList());

				List<GraphQLError> e = new ArrayList<>();
				e.addAll(clientErrors);
				e.addAll(serverErrors);
				return e;
			}

			protected boolean isClientError(GraphQLError error) {
				return !(error instanceof ExceptionWhileDataFetching || error instanceof Throwable);
			}
		};
	}

}
