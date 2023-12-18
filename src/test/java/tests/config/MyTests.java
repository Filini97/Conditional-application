package tests.config;

import conditionalapplication.ConditionalApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;



import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {TestConfig.class, ConditionalApplication.class})
public class MyTests {
    @Autowired
    private TestRestTemplate restTemplate;
    @Container
    private static final GenericContainer<?> devContainer = new GenericContainer<>("devapp")
            .withExposedPorts(8080);

    @Container
    private static final GenericContainer<?> prodContainer = new GenericContainer<>("prodapp")
            .withExposedPorts(8081);


    @BeforeEach
    void setUp() {
        devContainer.start();
        prodContainer.start();
    }

    @Test
     void testFirstContainer() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" + devContainer.getMappedPort(8080), String.class);
        assertEquals("ExpectedResponseFromAppContainer", forEntity.getBody());
    }

    @Test
    void testSecondContainer() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" + prodContainer.getMappedPort(8081), String.class);
        assertEquals("ExpectedResponseFromDevContainer", forEntity.getBody());
    }

}

