package uz.avaz.code.my_learning_platform.entitiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Base64;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "course_comment")
public class CourseComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String body;

    @Column(nullable = false)
    private LocalDateTime postedAt;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    Course course;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;


    public String getBase64() {
        if (this.user.getAttachment() != null){
            byte[] bytes = Base64.getEncoder().encode(user.getAttachment().getBytes());
            return new String(bytes, StandardCharsets.UTF_8);
        }
        return null;
    }
}
