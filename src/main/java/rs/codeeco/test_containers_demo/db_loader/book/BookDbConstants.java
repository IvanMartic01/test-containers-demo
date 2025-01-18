package rs.codeeco.test_containers_demo.db_loader.book;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BookDbConstants {

    public static final UUID BOOK_ID = UUID.fromString("08a35f37-7ea6-42c0-9a90-d6cd3aa01632");
    public static final String BOOK_TITLE = "The Lord of the Rings";
    public static final String BOOK_AUTHOR = "J.R.R. Tolkien";
    public static final String BOOK_ISBN = "978-3-16-148410-0";
    public static final LocalDate BOOK_PUBLISHED_DATE = LocalDate.now().minusYears(10);
}
