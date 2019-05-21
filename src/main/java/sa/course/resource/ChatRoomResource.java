package sa.course.resource;

import sa.course.model.ChatRoom;
import sa.course.service.ChatRoomService;
import sa.course.model.ChatRoomUser;
import sa.course.service.ChatRoomUserService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;
import java.util.List;

@Path("")
public class ChatRoomResource {

    ResponseBuilder response;

    @Context
    UriInfo uriInfo;

    @EJB
    ChatRoomService chatRoomService;

    @EJB
    ChatRoomUserService chatRoomUserService;


    @GET
    @Path("test")
    public Response TestConnection(){
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("get_rooms/{user_id}")
    public Response getChatFromUser(@PathParam("user_id") String user_id){
        response = Response.status(Response.Status.OK);
        //ChatRoom chatRoom = chatRoomService.getCourseByCode(user_id);
        //response.entity(chatRoom);//TODO:
        return response.build();
    }

    @GET
    @Path("get_users/{room_id}")
    public Response getChatFromUser(@PathParam("room_id") int room_id){
        response = Response.status(Response.Status.OK);
        ChatRoom chatRoom = chatRoomService.getCourseByCode(room_id);
        response.entity(chatRoom);
        return response.build();
    }

    @POST
    @Path("chatroom")
    public Response createChatRoom(ChatRoom chatRoom) {
        ChatRoom createdChatRoom = chatRoomService.createCourse(chatRoom);
        response = Response.status(Response.Status.CREATED);
        response.entity(createdChatRoom);
        return response.build();
    }

    @DELETE
    @Path("chatroom")
    public Response deleteChatRoom(ChatRoom chatRoom) {
        //Chat deletedChatRoom = chatRoomService.deleteCourse(chatRoom);
        response = Response.status(Response.Status.OK);
        //response.entity(deletedChatRoom);
        return response.build();
    }

    @POST
    @Path("user")
    public Response createChatRoomUser(ChatRoomUser chatRoomUser) {
        //ChatRoom createdChatRoom = chatRoomUserService.createCourse(chatRoomUser);
        response = Response.status(Response.Status.CREATED);
        //response.entity(createdChatRoom);
        return response.build();
    }

    @DELETE
    @Path("user")
    public Response deleteChatRoom(ChatRoomUser chatRoomUser) {
        //long deletedChatRoom = chatRoomUserService.deleteCourse(chatRoomUser);
        response = Response.status(Response.Status.OK);
        //response.entity(deletedChatRoom);
        return response.build();
    }

}
