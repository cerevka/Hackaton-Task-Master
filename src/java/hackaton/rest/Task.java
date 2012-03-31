package hackaton.rest;

import com.sun.jersey.api.view.Viewable;
import hackaton.controller.LoginController;
import hackaton.controller.ParserDate;
import hackaton.model.Comment;
import hackaton.model.CommentType;
import hackaton.model.DAO;
import hackaton.model.DAOImpl;
import hackaton.model.Ownership;
import hackaton.model.OwnershipType;
import hackaton.model.Priority;
import hackaton.model.User;
import java.util.Collections;
import java.util.Comparator;
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


@Path("/task")
public class Task {
    
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response createTask(@FormParam("title") String title,
            @FormParam("description") String description,
            @FormParam("deadline") String deadline,
            @FormParam("priority") String priority,
            @FormParam("state") String state,
            @FormParam("type") String type,
            @FormParam("id") String id,
            @FormParam("progress") String progress) {

        Map<String, Object> map = new HashMap<String, Object>();
        if (state.equals("") || type.equals("")) {
            map.put("error", "type.error");
            map.put("states", new DAOImpl().getAllStates());
            map.put("types", new DAOImpl().getAllTypes());
            return Response.ok(new Viewable("/newTask", map)).build();
        }
        hackaton.model.State sta = new DAOImpl().getState(state);
        hackaton.model.Type typ = new DAOImpl().getType(type);
        Date deadlineDate = new ParserDate().parseDate(deadline);
        Long taskId = -1L;
        int progressInt = -1;
        if (id != null) {
            try {
                taskId = Long.valueOf(id);
                progressInt = Integer.valueOf(progress);
            } catch (NumberFormatException ex) {
                map.put("error", "type.error");
                map.put("states", new DAOImpl().getAllStates());
                map.put("types", new DAOImpl().getAllTypes());
                return Response.ok(new Viewable("/newTask", map)).build();
            }

        }

        if (title.equals("") || description.equals("") || deadline.equals("") || typ == null || sta == null || deadlineDate == null) {
            map.put("error", "type.error");
            map.put("states", new DAOImpl().getAllStates());
            map.put("types", new DAOImpl().getAllTypes());
            if (id != null) {
                map.put("task", new DAOImpl().getTask(taskId));
                return Response.ok(new Viewable("/editTask", map)).build();
            }
            return Response.ok(new Viewable("/newTask", map)).build();
        } else {
            hackaton.model.Task task = null;
            if (taskId != -1) {
                hackaton.model.Task t = new DAOImpl().getTask(taskId);
                task = new hackaton.model.Task(taskId, title, description, Priority.valueOf(priority),
                        progressInt, t.getDateCreated(), deadlineDate, sta, typ);
            } else {
                task = new hackaton.model.Task(null, title, description, Priority.valueOf(priority),
                        0, new Date(), deadlineDate, sta, typ);
            }
            new DAOImpl().newTask(task);
            //map.put("task", task);
            map.put("states", new DAOImpl().getAllStates());
            map.put("types", new DAOImpl().getAllTypes());
            return Response.ok(new Viewable("/newTask", map)).build();
        }
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getTask() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("states", new DAOImpl().getAllStates());
        map.put("types", new DAOImpl().getAllTypes());
        return Response.ok(new Viewable("/newTask", map)).build();
    }

    @GET
    @Path("/edit/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response editTask(@PathParam("id") String id) {
        Long taskId = -1L;
        try {
            taskId = Long.valueOf(id);
        } catch (NumberFormatException ex) {
        }
        hackaton.model.Task task = new DAOImpl().getTask(taskId);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("states", new DAOImpl().getAllStates());
        map.put("types", new DAOImpl().getAllTypes());
        map.put("task", task);
        return Response.ok(new Viewable("/editTask", map)).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response showTask(@PathParam("id") String id) {
        DAOImpl dao = new DAOImpl();
        Long taskId = -1L;
        try {
            taskId = Long.valueOf(id);
        } catch (NumberFormatException ex) {
        }
//        hackaton.model.Task task = new DAOImpl().getTask(taskId);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("task", dao.getTask(taskId));
        List<Ownership> ownershipByTaks = dao.getOwnershipByTaks(taskId);
        List<Comment> commentsForOwnerships = dao.getCommentsForOwnerships(ownershipByTaks);
        Collections.sort(commentsForOwnerships, new Comparator<Comment>() {

            public int compare(Comment o1, Comment o2) {
                return o2.getCreated().compareTo(o1.getCreated());
            }
        });
        map.put("comments", commentsForOwnerships);
        return Response.ok(new Viewable("/task", map)).build();
    }

    @POST
    @Path("/{id}/commet")
    public Response postComment(@PathParam("id") Long id, @FormParam("text") String commentText) {
        DAO dao = new DAOImpl();
        User user = new LoginController(dao).getUser();
        Ownership ownership = dao.getOwnershipForTaskByUser(id, user.getId());
        Comment comment = new Comment(null, commentText, new Date(), ownership, CommentType.MESSAGE);
        dao.storeComment(comment);
        return null;
    }
    
    @POST
    @Path("/{id}/ownership")
    public Response setOwnership(@PathParam("id") Long id) {
        DAO dao = new DAOImpl();
        User user = new LoginController(dao).getUser();
        hackaton.model.Task task = dao.getTask(id);
        Ownership ownership = new Ownership(null, OwnershipType.VOLUNTEER, user, task);
        dao.storeOwnership(ownership);
        return null;
    }
}
