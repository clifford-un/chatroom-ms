package sa.clifordun.chatroomms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sa.clifordun.chatroomms.Controllers.ChatroomController;
import sa.clifordun.chatroomms.Models.Chatroom;

@SpringBootApplication
public class Application implements CommandLineRunner{

    @Autowired
    private ChatroomController controller;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //controller.deleteAll();

        // save a couple of customers
        controller.save(new Chatroom("CR1"));
        controller.save(new Chatroom("CR2"));

        // fetch all customers
        System.out.println("ChatRooms:");
        System.out.println("-------------------------------");
        for (Chatroom room : controller.findAll()) {
            System.out.println(room);
        }
        System.out.println();

    }
}
