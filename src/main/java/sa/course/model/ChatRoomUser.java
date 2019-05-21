package sa.course.model;

import javax.persistence.*;

@Entity
@Table(name = "chat_room_user")
public class ChatRoomUser {

    public static final String FIND_ALL = "ChatRoomUser.findAll";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatroom_id;

    private String user_id;

    public Long getChatRoomId() {
        return this.chatroom_id;
    }
    public void setChatRoomId(Long id) {
        this.chatroom_id = id;
    }

    public String getUserId(){
        return user_id;
    }
    public void setUserId(String id){
        this.user_id = id;
    }

}
