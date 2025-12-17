package models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "programs")
@Getter
@Setter
@NoArgsConstructor
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    private String code;
    private String name;
    private String level;
    private Integer durationSemesters;
    private String description;

    @OneToMany(mappedBy = "program")
    private java.util.List<SchoolClass> classes;
}
