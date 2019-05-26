package sa.clifordun.chatroomms.Models;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class Chatroom {

    @Id
    public String id;

    public String name;
    public List<Integer> users;

    public Chatroom(){
        users = new ArrayList<>();
    }

    public Chatroom(String name){
        this.name = name;
        users = new ArrayList<>();
    }

    @Override
    public String toString(){
        return this.id + " :\t" + this.name;
    }

}
