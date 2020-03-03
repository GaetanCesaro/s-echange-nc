package com.gegette.sechangenc;

import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ActiveProfiles(value="devh2")
public class MutationTest {

    @Autowired
    private GraphQLTestTemplate graphQLTestTemplate;

    @Test
    public void newUser() throws IOException {

        GraphQLResponse response = graphQLTestTemplate.perform("graphql/newUser.graphql", null);
        assertNotNull(response);
        assertTrue(response.isOk());
        assertEquals("Jean", response.get("$.data.newUser.firstName"));
        assertEquals("Tanrien", response.get("$.data.newUser.lastName"));
        assertEquals("jean.tanrien@gmail.com", response.get("$.data.newUser.email"));

    }

    @Test
    public void newPost() throws IOException {

        GraphQLResponse response = graphQLTestTemplate.perform("graphql/newPost.graphql", null);
        assertNotNull(response);
        assertTrue(response.isOk());
        assertEquals("4", response.get("$.data.newPost.id"));
        assertEquals("Table et chaises", response.get("$.data.newPost.title"));

    }

    @Test
    public void deletePost() throws IOException {

        GraphQLResponse response = graphQLTestTemplate.perform("graphql/deletePost.graphql", null);
        assertNotNull(response);
        assertTrue(response.isOk());
        assertTrue(response.get("$.data.deletePost", Boolean.class));

    }

    @Test
    public void updatePostPrice() throws IOException {

        GraphQLResponse response = graphQLTestTemplate.perform("graphql/updatePostPrice.graphql", null);
        assertNotNull(response);
        assertTrue(response.isOk());
        assertEquals("2", response.get("$.data.updatePostPrice.id"));
        assertTrue(50000 == response.get("$.data.updatePostPrice.price", Integer.class));

    }
}