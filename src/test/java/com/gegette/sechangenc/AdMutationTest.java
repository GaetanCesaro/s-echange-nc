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
public class AdMutationTest {

    @Autowired
    private GraphQLTestTemplate graphQLTestTemplate;

    @Test
    public void newAd() throws IOException {

        GraphQLResponse response = graphQLTestTemplate.perform("graphql/newAd.graphql", null);
        assertNotNull(response);
        assertTrue(response.isOk());
        assertEquals("9", response.get("$.data.newAd.id"));
        assertEquals("Table et chaises", response.get("$.data.newAd.title"));

    }

    @Test
    public void deleteAd() throws IOException {

        GraphQLResponse response = graphQLTestTemplate.perform("graphql/deleteAd.graphql", null);
        assertNotNull(response);
        assertTrue(response.isOk());
        assertTrue(response.get("$.data.deleteAd", Boolean.class));

    }

    @Test
    public void updateAdPrice() throws IOException {

        GraphQLResponse response = graphQLTestTemplate.perform("graphql/updateAdPrice.graphql", null);
        assertNotNull(response);
        assertTrue(response.isOk());
        assertEquals("2", response.get("$.data.updateAdPrice.id"));
        assertTrue(50000 == response.get("$.data.updateAdPrice.price", Integer.class));

    }
}