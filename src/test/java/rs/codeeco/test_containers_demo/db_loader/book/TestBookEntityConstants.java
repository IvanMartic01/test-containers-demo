package rs.codeeco.test_containers_demo.db_loader.book;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import rs.codeeco.test_containers_demo.entity.BookEntity;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TestBookEntityConstants {

    public static BookEntity buildBook1() {
        return BookEntity.builder()
                .id(TestBookDbConstants.BOOK_1_ID)
                .title(TestBookDbConstants.BOOK_1_TITLE)
                .author(TestBookDbConstants.BOOK_1_AUTHOR)
                .isbn(TestBookDbConstants.BOOK_1_ISBN)
                .publishedDate(TestBookDbConstants.BOOK_1_PUBLISHED_DATE)
                .build();
    }

    public static BookEntity buildBook2() {
        return BookEntity.builder()
                .id(TestBookDbConstants.BOOK_2_ID)
                .title(TestBookDbConstants.BOOK_2_TITLE)
                .author(TestBookDbConstants.BOOK_2_AUTHOR)
                .isbn(TestBookDbConstants.BOOK_2_ISBN)
                .publishedDate(TestBookDbConstants.BOOK_2_PUBLISHED_DATE)
                .build();
    }

    public static BookEntity buildBook3() {
        return BookEntity.builder()
                .id(TestBookDbConstants.BOOK_3_ID)
                .title(TestBookDbConstants.BOOK_3_TITLE)
                .author(TestBookDbConstants.BOOK_3_AUTHOR)
                .isbn(TestBookDbConstants.BOOK_3_ISBN)
                .publishedDate(TestBookDbConstants.BOOK_3_PUBLISHED_DATE)
                .build();
    }
}
