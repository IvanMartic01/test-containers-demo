package rs.codeeco.test_containers_demo.db_loader.author;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
class AuthorDbConstants {

    public static final UUID AUTHOR_ID_1 = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");
    public static final String AUTHOR_NAME_1 = "John";
    public static final String AUTHOR_SURNAME_1 = "Doe";
    public static final int AUTHOR_AGE_1 = 45;
}
