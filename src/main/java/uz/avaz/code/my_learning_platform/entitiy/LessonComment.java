package uz.avaz.code.my_learning_platform.entitiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "lesson_comment")
public class LessonComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String body;

    @Column(nullable = false)
    private LocalDateTime postAt;

    @ManyToOne
    @JoinColumn(name = "lesson_id",nullable = false)
    Lesson lesson;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    User user;
}
