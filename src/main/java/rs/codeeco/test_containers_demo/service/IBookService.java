package rs.codeeco.test_containers_demo.service;

import rs.codeeco.test_containers_demo.entity.BookEntity;

import java.util.Collection;
import java.util.UUID;

public interface IBookService {

    Collection<BookEntity> getAll();

    BookEntity getById(UUID bookId);

    BookEntity create(BookEntity book);

    Collection<BookEntity> saveAll(Collection<BookEntity> books);

    BookEntity update(BookEntity book);

    void delete(UUID bookId);
}
