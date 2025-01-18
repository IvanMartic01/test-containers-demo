package rs.codeeco.test_containers_demo.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import rs.codeeco.test_containers_demo.entity.BookEntity;
import rs.codeeco.test_containers_demo.service.IBookService;

import java.util.Collection;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@Validated
public class BookController {

    private final IBookService bookService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/book")
    public Collection<BookEntity> getAll() {
        return bookService.getAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/book/{bookId}")
    public BookEntity getById(@PathVariable UUID bookId) {
        return bookService.getById(bookId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/book")
    public BookEntity create(@Valid @RequestBody BookEntity book) {
        return bookService.create(book);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/book/{bookId}")
    public BookEntity update(@Valid @RequestBody BookEntity book) {
        return bookService.update(book);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{bookId}")
    public void delete(@PathVariable UUID bookId) {
        bookService.delete(bookId);
    }
}
