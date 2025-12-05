package models;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class FileEntity {
    private Integer id;
    private String ownerType;
    private Integer ownerId;
    private String filename;
    private String filepath;
    private String mimeType;
    private Long sizeBytes;
    private Integer uploadedBy;
    private LocalDateTime uploadedAt;
}
