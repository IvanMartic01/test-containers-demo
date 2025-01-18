package rs.codeeco.test_containers_demo.db_loader.author;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import rs.codeeco.test_containers_demo.service.IAuthorService;

import static rs.codeeco.test_containers_demo.db_loader.author.TestAuthorEntityConstants.buildAuthor1;

@Slf4j
@RequiredArgsConstructor
@Configuration
class TestAuthorDbLoader implements CommandLineRunner {

    private final IAuthorService authorService;

    @Override
    public void run(String... args) throws Exception {
        try {
            log.info("Loading authors...");
            authorService.create(buildAuthor1());
            log.info("Authors loaded.");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
