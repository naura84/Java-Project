package models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;
    private String code;
    private String name;
    @ManyToOne
    @JoinColumn(name = "head_id")
    private Enseignant head;

    @OneToMany(mappedBy = "department")
    private java.util.List<Program> programs;
}
