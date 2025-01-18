package rs.codeeco.test_containers_demo.db_loader.book;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class TestBookDbConstants {

    public static final UUID BOOK_1_ID = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");
    public static final String BOOK_1_TITLE = "1984";
    public static final String BOOK_1_AUTHOR = "George Orwell";
    public static final String BOOK_1_ISBN = "978-0-452-28423-4";
    public static final LocalDate BOOK_1_PUBLISHED_DATE = LocalDate.now();

    public static final UUID BOOK_2_ID = UUID.fromString("123e4567-e89b-12d3-a456-426614174001");
    public static final String BOOK_2_TITLE = "To Kill a Mockingbird";
    public static final String BOOK_2_AUTHOR = "Harper Lee";
    public static final String BOOK_2_ISBN = "978-0-06-112008-4";
    public static final LocalDate BOOK_2_PUBLISHED_DATE = LocalDate.now();

    public static final UUID BOOK_3_ID = UUID.fromString("123e4567-e89b-12d3-a456-426614174002");
    public static final String BOOK_3_TITLE = "Pride and Prejudice";
    public static final String BOOK_3_AUTHOR = "Jane Austen";
    public static final String BOOK_3_ISBN = "978-0-19-953556-9";
    public static final LocalDate BOOK_3_PUBLISHED_DATE = LocalDate.now();
}
