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

    public List<ChatRoom> getAllCourses(int first, int maxResult) {
        return entityManager.createNamedQuery(ChatRoom.FIND_ALL)
                .setFirstResult(first).setMaxResults(maxResult).getResultList();
    }

    public ChatRoom getCourseByCode(long code){
        return entityManager.find(ChatRoom.class, code);
    }

    public ChatRoom createCourse(ChatRoom chatRoom) {
        entityManager.persist(chatRoom);
        entityManager.flush();
        return chatRoom;
    }

    public ChatRoom updateCourse(long code, ChatRoom chatRoom) {
        ChatRoom chatRoomToUpdate = entityManager.find(ChatRoom.class, code);
        chatRoomToUpdate.setName(chatRoom.getName());
        entityManager.merge(chatRoomToUpdate);
        return entityManager.find(ChatRoom.class, code);
    }

    public long deleteCourse(long code) {
        ChatRoom chatRoom = entityManager.find(ChatRoom.class, code);
        entityManager.remove(chatRoom);
        return code;
    }
}
