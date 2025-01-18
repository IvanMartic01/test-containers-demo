package rs.codeeco.test_containers_demo.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import rs.codeeco.test_containers_demo.entity.BookEntity;
import rs.codeeco.test_containers_demo.repo.BookRepository;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static rs.codeeco.test_containers_demo.db_loader.book.TestBookEntityConstants.*;

@Testcontainers
@DataJdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class BookRepositoryTest {

    // static means that the container will be shared between all test methods

    // @Testcontainers enables automatic management of containers in to all @Container fields in the test class.
    // That means that the life of the container will be managed automatically by testcontainers otherwise we would have to start and stop the container manually.
    // @Container is used to mark individual containers that should be managed by Testcontainers.

    // @ServiceConnection enables auto config of the container and application properties for the service connection.
    // Enable management of container lifecycle, so annotation @TestContainers and @Container are not needed. (redundant configuration)
    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:latest");

    @Autowired
    private BookRepository repository;

    @BeforeEach
    void setUp() {
        Collection<BookEntity> books = List.of(buildBook1(), buildBook2());
        repository.saveAll(books);
    }

    @Test
    void connectionEstablished() {
        assertThat(postgres.isCreated()).isTrue();
        assertThat(postgres.isRunning()).isTrue();
    }


    @Test
    @DisplayName("Test case: Creation of a book")
    @Tag("Positive")
    void testThatCreationOfBookWorksCorrectly() {
        BookEntity book = buildBook3();
        repository.save(book);
        BookEntity createdBook = repository.findById(book.getId())
                .orElse(null);

        assertThat(book)
                .usingRecursiveComparison()
                .isEqualTo(createdBook);
    }

//     In the past, before Spring Boot 3.1, we had to manually set the database configuration in the test class
//    @Container
//    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:latest")
//            .withDatabaseName("prop")
//            .withUsername("postgres")
//            .withPassword("pass")
//            .withExposedPorts(5432);
//    @DynamicPropertySource
//    static void dataSourceProperties(DynamicPropertyRegistry registry) {
//        registry.add("spring.datasource.url", () -> String.format("jdbc:postgresql://localhost:%d/prop", postgres.getFirstMappedPort()));
//        registry.add("spring.datasource.username", () -> "postgres");
//        registry.add("spring.datasource.password", () -> "pass");
//        registry.add("spring.liquibase.change-log", () -> "classpath:/db/changelog/db.changelog-master.xml");
//    }
}
