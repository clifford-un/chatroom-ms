package sa.course.service;

import sa.course.model.ChatRoom;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ChatRoomService {

    @PersistenceContext
    EntityManager entityManager;

    public ChatRoom getChatRoomById(long room_id){
        return entityManager.find(ChatRoom.class, room_id);
    }

    public ChatRoom createChatRoom(ChatRoom chatRoom) {
        entityManager.persist(chatRoom);
        entityManager.flush();
        return chatRoom;
    }

    public ChatRoom updateChatRoom(long room_id, ChatRoom chatRoom) {
        ChatRoom chatRoomToUpdate = entityManager.find(ChatRoom.class, room_id);
        chatRoomToUpdate.setName(chatRoom.getName());
        entityManager.merge(chatRoomToUpdate);
        return entityManager.find(ChatRoom.class, room_id);
    }

    public long deleteChatRoom(long room_id) {
        ChatRoom chatRoom = entityManager.find(ChatRoom.class, room_id);
        entityManager.remove(chatRoom);
        return room_id;
    }
}
