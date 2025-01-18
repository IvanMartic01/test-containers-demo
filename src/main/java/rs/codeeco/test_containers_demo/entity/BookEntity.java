package rs.codeeco.test_containers_demo.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Builder(toBuilder = true)
@Table("book")
public class BookEntity implements Persistable<UUID> {

    @Id
    private UUID id;

    @NonNull
    private String title;

    @NonNull
    private String author;

    @NonNull
    private String isbn;

    @NonNull
    private LocalDate publishedDate;

    @Override
    public boolean isNew() {
        return true; // Entity is considered new if the ID is null
    }
}
