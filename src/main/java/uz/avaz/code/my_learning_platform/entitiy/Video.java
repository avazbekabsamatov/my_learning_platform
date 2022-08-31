package uz.avaz.code.my_learning_platform.entitiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "videos")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_location", nullable = false)
    private String fileLocation;

    @Column(name = "original_file_name")
    private String originalFileName;

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @Column(name = "content_type")
    private String contentType;

    @ManyToOne
    @JoinColumn(name = "lesson_id", nullable = false)
    Lesson lesson;


    public Video(String fileLocation, String fileName) {
        this.fileLocation = fileLocation;
        this.fileName = fileName;
    }
}
