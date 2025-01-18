package rs.codeeco.test_containers_demo.db_loader.author;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TestAuthorDbConstants {

    public static final UUID AUTHOR_ID_1 = UUID.fromString("123e4567-e89b-12d3-a456-426614174001");
    public static final String AUTHOR_NAME_1 = "Jane";
    public static final String AUTHOR_SURNAME_1 = "Smith";
    public static final int AUTHOR_AGE_1 = 30;

    public static final UUID AUTHOR_ID_2 = UUID.fromString("123e4567-e89b-12d3-a456-426614174002");
    public static final String AUTHOR_NAME_2 = "Emily";
    public static final String AUTHOR_SURNAME_2 = "Johnson";
    public static final int AUTHOR_AGE_2 = 60;
}
