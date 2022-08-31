package uz.avaz.code.my_learning_platform.entitiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String theme;

    @ManyToOne
    @JoinColumn(name = "module_id",nullable = false)
    Module module;

    @OneToMany(mappedBy = "lesson")
    List<Task> tasks;

    @OneToMany(mappedBy = "lesson")
    List<Video> videos;

    @OneToMany(mappedBy = "lesson")
    List<LessonComment> lessonComments;
}
