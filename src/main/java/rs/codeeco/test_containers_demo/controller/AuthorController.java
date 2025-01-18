package rs.codeeco.test_containers_demo.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import rs.codeeco.test_containers_demo.entity.AuthorEntity;
import rs.codeeco.test_containers_demo.service.IAuthorService;

import java.util.Collection;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@Validated
public class AuthorController {

    private final IAuthorService authorService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/author")
    public Collection<AuthorEntity> getAll() {
        return authorService.getAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/author/{authorId}")
    public AuthorEntity getById(@PathVariable UUID authorId) {
        return authorService.getById(authorId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/author")
    public AuthorEntity create(@Valid @RequestBody AuthorEntity author) {
        return authorService.create(author);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/author/{authorId}")
    public AuthorEntity update(@Valid @RequestBody AuthorEntity author) {
        return authorService.update(author);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{authorId}")
    public void delete(@PathVariable UUID authorId) {
        authorService.delete(authorId);
    }
}
