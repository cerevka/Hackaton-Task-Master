package hackaton.rest;

import com.sun.jersey.api.view.Viewable;
import hackaton.model.Comment;
import hackaton.model.CommentType;
import hackaton.model.DAOImpl;
import hackaton.model.Ownership;
import hackaton.model.OwnershipType;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/userToTask")
public class UserToTask {

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response addUserToTask(@FormParam("id") Long id, @FormParam("user") Long userId) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (userId == null) {
            map.put("users", new DAOImpl().getAllUsers());
            map.put("task", new DAOImpl().getTask(id));
            return Response.ok(new Viewable("/addUsersToTasks", map)).build();
        }
        hackaton.model.Task task = new DAOImpl().getTask(id);
        hackaton.model.User us = new DAOImpl().getUser(userId);
        Ownership ownership = new Ownership(null, OwnershipType.ASSIGNED, us, task);
        new DAOImpl().storeOwnership(ownership);
        Ownership own = new DAOImpl().getOwnershipForTaskByUser(task.getId(), us.getId());
        Comment comment = new Comment(null, "Přidán uživatel " + us.getFirstname() + " " + us.getSurname(), new Date(), own, CommentType.ACTION);
        new DAOImpl().storeComment(comment);

        List<TaskOverview> l = new ArrayList<TaskOverview>();
        for (hackaton.model.Task t : new DAOImpl().getAllTasks()) {
            l.add(new TaskOverview(t.getTitle(), t.getDescription(), t.getTypeName(), t.getStateName(), "/rest/task/" + t.getId(), t.getProgress(), t.getPriority()));
        }
        map.put("tasks", l);
        return Response.ok(new Viewable("/tasks", map)).build();
//        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response showUsers(@PathParam("id") String id) {
        Map<String, Object> map = new HashMap<String, Object>();
        Long taskId = -1L;
        try {
            taskId = Long.valueOf(id);
        } catch (NumberFormatException ex) {
            List<TaskOverview> l = new ArrayList<TaskOverview>();
            for (hackaton.model.Task t : new DAOImpl().getAllTasks()) {
                l.add(new TaskOverview(t.getTitle(), t.getDescription(), t.getTypeName(), t.getStateName(), "/rest/task/" + t.getId(), t.getProgress(), t.getPriority()));
            }
            map.put("tasks", l);
            return Response.ok(new Viewable("/tasks", map)).build();
        }

        map.put("users", new DAOImpl().getAllUsers());
        map.put("task", new DAOImpl().getTask(taskId));
        return Response.ok(new Viewable("/addUsersToTask", map)).build();
    }
}
