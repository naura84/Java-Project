package models;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class LibraryBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "book")
    private java.util.List<LibraryLoan> loans;
}
