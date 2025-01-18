package rs.codeeco.test_containers_demo.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import rs.codeeco.test_containers_demo.entity.BookEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static rs.codeeco.test_containers_demo.db_loader.book.TestBookEntityConstants.buildBook3;

// Load the Spring context
// Spin up tomcat server
// Each test class will start on container
@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class BookControllerTest {

    // @SpringBootTest is used to load the entire Spring context - load the Spring context and spin up tomcat server
    // Because is used @SpringBootTest and load the entire Spring context, it will load data from CommandLineRunner (in test directory), in app is annotated with @Profile("test")

    // @AutoConfigureMockMvc
    // 1. Loads entire Spring context
    // 2. Enables testing controllers with MockMvc without running real web server
    // 3. It will simulate HTTP requests and responses inside spring context
    // 4. Faster testing without running real web server
    // 5. Testing without a network layer, less realistic testing

    // TestRestTemplate
    // 1. User real HTTP client
    // 2. Simulates real HTTP requests and responses
    // 3. Realistic testing (E2E test), adding network layer
    // 4. Slower testing because of stating real web server

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:latest");

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void connectionEstablished() {
        assertThat(postgres.isCreated()).isTrue();
        assertThat(postgres.isRunning()).isTrue();
    }

    @Test
    @DisplayName("Test case: Find all books")
    void shouldFindAllBooks() {
        BookEntity[] books = restTemplate.getForObject("/book", BookEntity[].class);
        assertThat(books).hasSize(1);
    }

    @Test
    @DisplayName("Test case: Create new book")
    void shouldCreateNewBookWhenBookIsValid() {
        BookEntity book = buildBook3();
        ResponseEntity<BookEntity> response = restTemplate.postForEntity("/book", book, BookEntity.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getTitle()).isEqualTo(book.getTitle());
        assertThat(response.getBody().getAuthor()).isEqualTo(book.getAuthor());
        assertThat(response.getBody().getIsbn()).isEqualTo(book.getIsbn());
        assertThat(response.getBody().getPublishedDate()).isEqualTo(book.getPublishedDate());
    }
}
