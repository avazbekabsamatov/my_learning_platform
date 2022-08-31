package uz.avaz.code.my_learning_platform.entitiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "result")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @OneToOne
    @JoinColumn(name = "submission_id", nullable = false, referencedColumnName = "id")
    Submission submission;

    @Column(name = "is_correct", nullable = false)
    Boolean isCorrect;

    @Column(nullable = false)
    Double ball;
}
