package com.example.springbootconditional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBootConditionalApplicationTests {

    @Container
    @SuppressWarnings("resource")
    private static final GenericContainer<?> devAppContainer = new GenericContainer<>("dev-app2")
            .withExposedPorts(8080);
    @Container
    @SuppressWarnings("resource")
    private static final GenericContainer<?> prodAppContainer = new GenericContainer<>("prod-app2")
            .withExposedPorts(8081);
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testDevAppContainer() {
        ResponseEntity<String> response = restTemplate.getForEntity(
                "http://localhost:" + devAppContainer.getMappedPort(8080), String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testProdAppContainer() {
        ResponseEntity<String> response = restTemplate.getForEntity(
                "http://localhost:" + prodAppContainer.getMappedPort(8081), String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
