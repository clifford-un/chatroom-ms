package sa.clifordun.chatroomms.Resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sa.clifordun.chatroomms.Controllers.ChatroomController;
import sa.clifordun.chatroomms.Models.Chatroom;
import sa.clifordun.chatroomms.Models.ChatroomUser;

import java.util.LinkedList;

@RestController
public class ChatRoomResource {

    @Autowired
    private ChatroomController controller;

    @GetMapping("/test")
    public ResponseEntity<Object> test() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/chatroom/{id}")
    public ResponseEntity<Object> getById(@PathVariable String id){
        return new ResponseEntity<>(controller.getById(id), HttpStatus.OK);
    }

    @GetMapping("/chatroom/name/{name}")
    public ResponseEntity<Object> getByName(@PathVariable String name){
        return new ResponseEntity<>(controller.getByName(name), HttpStatus.OK);
    }

    @PostMapping("/chatroom")
    public ResponseEntity<Object> createChatRoom(@RequestBody Chatroom room){
        controller.save(room);
        return new ResponseEntity<>(room, HttpStatus.CREATED);
    }

    @PostMapping("/user")
    public ResponseEntity<Object> addUser(@RequestBody ChatroomUser user){

        Chatroom room = controller.getById(user.room_id);
        room.users.add(user.user_id);
        controller.save(room);

        return new ResponseEntity<>(room, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/chatroom/{id}")
    public ResponseEntity<Object> deleteChatRoom(@PathVariable String id){
        controller.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/user")
    public ResponseEntity<Object> removeUser(@RequestBody ChatroomUser user){

        Chatroom room = controller.getById(user.room_id);
        room.users.remove(user.user_id);
        controller.save(room);

        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @GetMapping("/chatrooms/{id}")
    public ResponseEntity<Object> getChatroomsFromUser(@PathVariable Integer id){
        LinkedList<Chatroom> rooms = new LinkedList<>();
        for(Chatroom room : controller.findAll()){
            if(room.users.contains(id))
                rooms.add(room);
        }
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Object> getUsersFromChatroom(@PathVariable String id){
        return new ResponseEntity<>(controller.getById(id).users, HttpStatus.OK);
    }

}
