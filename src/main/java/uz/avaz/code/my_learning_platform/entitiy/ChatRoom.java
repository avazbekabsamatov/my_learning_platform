package uz.avaz.code.my_learning_platform.entitiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "chat_rooms")
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id1",nullable = false)
    private User user1;

    @ManyToOne
    @JoinColumn(name = "user_id2",nullable = false)
    private User user2;

    @OneToMany(mappedBy = "chatRoom")
    private List<Message> messages;

    @Transient
    private String guestUserImage;

    @Transient
    private String myImage;

    @Transient
    private Long newMessagesCount;

    public ChatRoom(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
    }
}
