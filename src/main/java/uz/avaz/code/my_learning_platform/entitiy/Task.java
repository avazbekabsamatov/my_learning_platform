package uz.avaz.code.my_learning_platform.entitiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String questions;

    @ManyToOne
    @JoinColumn(name = "lesson_id", nullable = false, referencedColumnName = "id")
    Lesson lesson;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "attachment_id",referencedColumnName = "id",nullable = false)
    Attachment attachment;
}
