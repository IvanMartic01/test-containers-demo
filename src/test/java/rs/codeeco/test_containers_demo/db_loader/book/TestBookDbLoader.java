package rs.codeeco.test_containers_demo.db_loader.book;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import rs.codeeco.test_containers_demo.service.IBookService;

import static rs.codeeco.test_containers_demo.db_loader.book.TestBookEntityConstants.buildBook1;

@Slf4j
@RequiredArgsConstructor
@Configuration
class TestBookDbLoader implements CommandLineRunner {

    private final IBookService bookService;

    @Override
    public void run(String... args) throws Exception {
        try {
            log.info("Loading books...");
            bookService.create(buildBook1());
            log.info("Books loaded.");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
