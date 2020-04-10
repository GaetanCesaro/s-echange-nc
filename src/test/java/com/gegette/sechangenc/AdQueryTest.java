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
import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ActiveProfiles(value="devh2")
public class AdQueryTest {

    @Autowired
    private GraphQLTestTemplate graphQLTestTemplate;

    @Test
    public void findAllAds() throws IOException {

        GraphQLResponse response = graphQLTestTemplate.perform("graphql/findAllAds.graphql", null);
        assertNotNull(response);
        assertTrue(response.isOk());
        assertEquals("1", response.get("$.data.findAllAds[0].id"));
        assertEquals("Bricolage mobilier intérieur", response.get("$.data.findAllAds[0].title"));

    }

}