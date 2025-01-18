package rs.codeeco.test_containers_demo.db_loader.author;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import rs.codeeco.test_containers_demo.entity.AuthorEntity;
import rs.codeeco.test_containers_demo.service.IAuthorService;

@Profile("local")
@RequiredArgsConstructor
@Component
class AuthorDbLoader implements CommandLineRunner {

    private final IAuthorService authorService;

    @Override
    public void run(String... args) {
        try {
            AuthorEntity book = buildAuthor();
            authorService.create(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static AuthorEntity buildAuthor() {
        return AuthorEntity.builder()
                .id(AuthorDbConstants.AUTHOR_ID_1)
                .name(AuthorDbConstants.AUTHOR_NAME_1)
                .surname(AuthorDbConstants.AUTHOR_SURNAME_1)
                .age(AuthorDbConstants.AUTHOR_AGE_1)
                .build();
    }
}
