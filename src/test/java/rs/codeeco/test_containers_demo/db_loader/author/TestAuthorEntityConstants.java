package rs.codeeco.test_containers_demo.db_loader.author;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import rs.codeeco.test_containers_demo.entity.AuthorEntity;

import static rs.codeeco.test_containers_demo.db_loader.author.TestAuthorDbConstants.*;


@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TestAuthorEntityConstants {

    public static AuthorEntity buildAuthor1() {
        return AuthorEntity.builder()
                .id(AUTHOR_ID_1)
                .name(AUTHOR_NAME_1)
                .surname(AUTHOR_SURNAME_1)
                .age(AUTHOR_AGE_1)
                .build();
    }

    public static AuthorEntity buildAuthor2() {
        return AuthorEntity.builder()
                .id(TestAuthorDbConstants.AUTHOR_ID_2)
                .name(TestAuthorDbConstants.AUTHOR_NAME_2)
                .surname(TestAuthorDbConstants.AUTHOR_SURNAME_2)
                .age(TestAuthorDbConstants.AUTHOR_AGE_2)
                .build();
    }
}
