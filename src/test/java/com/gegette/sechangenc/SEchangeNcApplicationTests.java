package com.gegette.sechangenc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTest;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@GraphQLTest
class SEchangeNcApplicationTests {

	@Autowired
	private GraphQLTestTemplate graphQLTestTemplate;

	@Test
	@Ignore
	public void findAll() throws IOException {
		GraphQLResponse response = graphQLTestTemplate.postForResource("graphql/findAllPosts.graphql");
		assertNotNull(response);
//		assertTrue(response.isOk());
//		assertEquals("1", response.get("$.data.post.id"));
	}

//	@Test
//	public void get_comments_withFragments() throws IOException {
//		List<String> fragments = new ArrayList<>();
//		fragments.add("graphql/all-comment-fields-fragment.graphql");
//		GraphQLResponse response = graphQLTestTemplate.postForResource("graphql/post-get-comments-with-fragment.graphql", fragments);
//		assertNotNull(response);
//		assertTrue(response.isOk());
//		assertEquals("1", response.get("$.data.post.id"));
//	}

//	@Test
//	public void create_post() throws IOException {
//		ObjectNode variables = new ObjectMapper().createObjectNode();
//		variables.put("text", "lorem ipsum dolor sit amet");
//		GraphQLResponse response = graphQLTestTemplate.perform("graphql/create-post.graphql", variables);
//		assertNotNull(response);
//		assertNotNull(response.get("$.data.createPost.id"));
//	}

}
