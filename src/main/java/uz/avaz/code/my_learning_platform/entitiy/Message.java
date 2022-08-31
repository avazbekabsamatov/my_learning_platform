package uz.avaz.code.my_learning_platform.entitiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @Column(name = "send_at")
    private LocalDateTime sendAt;

    @ColumnDefault(value = "false")
    private Boolean isRead;

    @ManyToOne
    @JoinColumn(name = "from_id",nullable = false)
    User from;

    @ManyToOne
    @JoinColumn(name = "chat_room_id",nullable = false)
    ChatRoom chatRoom;
}
