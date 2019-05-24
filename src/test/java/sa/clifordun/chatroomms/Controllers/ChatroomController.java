package sa.clifordun.chatroomms.Controllers;

import org.springframework.data.mongodb.repository.MongoRepository;
import sa.clifordun.chatroomms.Models.Chatroom;

import java.util.List;

public interface ChatroomController  extends MongoRepository<Chatroom, String>{

    Chatroom getById(String Id);
    List<Chatroom> getByName(String Name);
}
