package rs.codeeco.test_containers_demo.db_loader.book;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import rs.codeeco.test_containers_demo.entity.BookEntity;
import rs.codeeco.test_containers_demo.service.IBookService;

@Profile("local")
@RequiredArgsConstructor
@Component
public class BookDbLoader implements CommandLineRunner {

    private final IBookService bookService;

    @Override
    public void run(String... args) {
        try {
            BookEntity book = buildBook();
            bookService.create(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static BookEntity buildBook() {
        return BookEntity.builder()
                .id(BookDbConstants.BOOK_ID)
                .title(BookDbConstants.BOOK_TITLE)
                .author(BookDbConstants.BOOK_AUTHOR)
                .isbn(BookDbConstants.BOOK_ISBN)
                .publishedDate(BookDbConstants.BOOK_PUBLISHED_DATE)
                .build();
    }
}
