package sa.course.model;

import javax.persistence.*;

@Entity
@Table(name = "chat_room")
@NamedQueries({@NamedQuery(name = ChatRoom.FIND_ALL, query = "SELECT u FROM ChatRoom u")})
public class ChatRoom {

    public static final String FIND_ALL = "ChatRoom.findAll";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    private String name;

    public Long getCode() {
        return code;
    }
    public void setCode(Long code) {
        this.code = code;
    }

    public String getName(){
      return name;
    }
    public void setName(String name){
      this.name = name;
    }

}
