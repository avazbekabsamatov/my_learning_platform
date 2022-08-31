package uz.avaz.code.my_learning_platform.entitiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;

import javax.persistence.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    private Double price;

    @ManyToMany
    @JoinTable(name = "authors_course",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "userId"))
    List<User> authors;

    @ManyToMany(mappedBy = "usersCourse")
    List<User> userList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "attachment_id", referencedColumnName = "id")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    Attachment attachment;

    @ManyToMany
    @JoinTable(name = "courses_modules",
    joinColumns = @JoinColumn(name = "course_id"),
    inverseJoinColumns = @JoinColumn(name = "module_id"))
    List<Module> modules;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    @OneToMany(mappedBy = "course")
    List<CourseComment> comments;

    @OneToMany(mappedBy = "course")
    List<CourseRate> votes;

    public String getBase64(){
        if (attachment!=null){
            byte[] bytes = Base64.getEncoder().encode(attachment.getBytes());
            return new String(bytes, StandardCharsets.UTF_8);
        }
        return null;
    }
}
