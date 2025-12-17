package models;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "files")
@Getter
@Setter
@NoArgsConstructor
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ownerType;
    private Integer ownerId;
    private String filename;
    private String filepath;
    private String mimeType;
    private Long sizeBytes;
    @ManyToOne
    @JoinColumn(name = "uploaded_by")
    private User uploadedBy;
    private LocalDateTime uploadedAt;
}
