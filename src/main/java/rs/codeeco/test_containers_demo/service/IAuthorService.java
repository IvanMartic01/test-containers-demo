package rs.codeeco.test_containers_demo.service;

import rs.codeeco.test_containers_demo.entity.AuthorEntity;

import java.util.Collection;
import java.util.UUID;

public interface IAuthorService {
    Collection<AuthorEntity> getAll();

    AuthorEntity getById(UUID authorId);

    AuthorEntity create(AuthorEntity author);

    Collection<AuthorEntity> saveAll(Collection<AuthorEntity> authors);

    AuthorEntity update(AuthorEntity author);

    void delete(UUID authorId);
}
