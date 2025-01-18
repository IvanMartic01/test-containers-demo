package rs.codeeco.test_containers_demo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.codeeco.test_containers_demo.entity.AuthorEntity;
import rs.codeeco.test_containers_demo.repo.AuthorRepository;
import rs.codeeco.test_containers_demo.service.IAuthorService;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AuthorService implements IAuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public Collection<AuthorEntity> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public AuthorEntity getById(UUID authorId) {
        return authorRepository.findById(authorId)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public AuthorEntity create(AuthorEntity author) {
        if (existById(author.getId())) {
            throw new KeyAlreadyExistsException();
        }
        return authorRepository.save(author);
    }

    @Override
    public Collection<AuthorEntity> saveAll(Collection<AuthorEntity> authors) {
        for (AuthorEntity author : authors) {
            if (existById(author.getId())) {
                throw new KeyAlreadyExistsException();
            }
        }

        return authorRepository.saveAll(authors);
    }

    @Override
    public AuthorEntity update(AuthorEntity author) {
        if (!existById(author.getId())) {
            throw new NoSuchElementException();
        }
        return authorRepository.save(author);
    }

    @Override
    public void delete(UUID authorId) {
        authorRepository.deleteById(authorId);
    }

    private boolean existById(UUID authorId) {
        return authorRepository.existsById(authorId);
    }
}
