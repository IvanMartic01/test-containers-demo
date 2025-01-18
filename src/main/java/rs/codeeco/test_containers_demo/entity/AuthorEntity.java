package rs.codeeco.test_containers_demo.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Getter
@Builder(toBuilder = true)
@Table("author")
public class AuthorEntity implements Persistable<UUID> {

    @Id
    private UUID id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String surname;

    @NonNull
    @Min(1)
    @Max(180)
    private Integer age;

    @Override
    public boolean isNew() {
        return true;
    }
}
