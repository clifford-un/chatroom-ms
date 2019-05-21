package sa.course.resource;

import sa.course.model.ChatRoom;
import sa.course.service.ChatRoomService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;
import java.util.List;

@Path("/room")
public class ChatRoomUserResource {

    ResponseBuilder response;

    @Context
    UriInfo uriInfo;

    @EJB
    ChatRoomService chatRoomService;

    @GET
    public List<ChatRoom> getAllCourses(@QueryParam("first") int first, @QueryParam("maxResult") int maxResult) {
        return chatRoomService.getAllCourses(first, maxResult);
    }

    @GET
    @Path("{code}")
    public Response getCourseByCode(@PathParam("code") long code) {
        ChatRoom chatRoom = chatRoomService.getCourseByCode(code);
        response = Response.status(Response.Status.OK);
        response.entity(chatRoom);
        return response.build();
    }

    @POST
    public Response createCourse(ChatRoom chatRoom) {
        ChatRoom createdChatRoom = chatRoomService.createCourse(chatRoom);
        response = Response.status(Response.Status.CREATED);
        response.entity(createdChatRoom);
        return response.build();
    }

    @PUT
    @Path("{code}")
    public Response updateCourse(@PathParam("code") long code, ChatRoom chatRoom) {
        ChatRoom updatedChatRoom = chatRoomService.updateCourse(code, chatRoom);
        response = Response.status(Response.Status.OK);
        response.entity(updatedChatRoom);
        return response.build();
    }

    @DELETE
    @Path("{code}")
    public Response deleteCourse(@PathParam("code") long code) {
        long deletedCourseCode = chatRoomService.deleteCourse(code);
        response = Response.status(Response.Status.OK);
        response.entity(deletedCourseCode);
        return response.build();
    }

}
