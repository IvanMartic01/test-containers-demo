package rs.codeeco.test_containers_demo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.codeeco.test_containers_demo.entity.BookEntity;
import rs.codeeco.test_containers_demo.repo.BookRepository;
import rs.codeeco.test_containers_demo.service.IBookService;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class BookService implements IBookService {

    private final BookRepository bookRepository;

    @Override
    public Collection<BookEntity> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public BookEntity getById(UUID bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public BookEntity create(BookEntity book) {
        if (existById(book.getId())) {
            throw new KeyAlreadyExistsException();
        }
        return bookRepository.save(book);
    }
    
    @Override
    public Collection<BookEntity> saveAll(Collection<BookEntity> books) {
        for (BookEntity book : books) {
            if (existById(book.getId())) {
                throw new KeyAlreadyExistsException();
            }
        }

        return bookRepository.saveAll(books);
    }

    @Override
    public BookEntity update(BookEntity book) {
        if (!existById(book.getId())) {
            throw new NoSuchElementException();
        }
        return bookRepository.save(book);
    }

    @Override
    public void delete(UUID bookId) {
        bookRepository.deleteById(bookId);
    }

    private boolean existById(UUID bookId) {
        return bookRepository.existsById(bookId);
    }
}
