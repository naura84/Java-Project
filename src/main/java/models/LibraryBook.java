package models;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class LibraryBook {
    private Integer id;
    private String isbn;
    private String title;
    private String authors;
    private String publisher;
    private Integer yearPublication;
    private Integer copiesTotal;
    private Integer copiesAvailable;
    private String location;
    private String subjects;
    private LocalDateTime createdAt;
}
