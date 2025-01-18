package rs.codeeco.test_containers_demo.repo;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import rs.codeeco.test_containers_demo.entity.BookEntity;

import java.util.UUID;

@Repository
public interface BookRepository extends ListCrudRepository<BookEntity, UUID> {
}
