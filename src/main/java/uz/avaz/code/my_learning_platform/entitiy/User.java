package uz.avaz.code.my_learning_platform.entitiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    private String bio;

    private Double balance;

    @Column(name = "left_at")
    @ColumnDefault(value = "now()")
    LocalDateTime leftAt;

    @Transient
    String leftAtS;

    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    Set<Role> roles;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "users_courses",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    List<Course> usersCourse;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "attachment_id", referencedColumnName = "id")
    private Attachment attachment;

    @OneToMany(mappedBy = "user")
    List<CourseRate> courseVotes;

    @OneToMany(mappedBy = "user")
    private List<CourseComment> comments;

    @OneToMany(mappedBy = "user")
    private List<LessonComment> lessonComments;

    @OneToMany(mappedBy = "from")
    private List<Message> messages;

    @OneToMany(mappedBy = "user1")
    private List<ChatRoom> chatRoom1;

    @OneToMany(mappedBy = "user2")
    private List<ChatRoom> chatRoom2;

    public User(Long id, String firstName, String lastName, String email, String bio, Double balance, LocalDateTime leftAt, Attachment attachment) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.bio = bio;
        this.balance = balance;
        this.leftAt = leftAt;
        this.attachment = attachment;
    }

    public String getBase64() {
        if (attachment != null){
            byte[] bytes = Base64.getEncoder().encode(attachment.getBytes());
            return new String(bytes, StandardCharsets.UTF_8);
        }
        return null;
    }
}
