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
import hackaton.model.State;
import hackaton.model.Task;
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
public class taskResource {
    
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
                if (!t.getState().getName().equals(sta.getName())) {
                    createChangeStateActionMessage(t, sta);
                }
                if (t.getProgress() != progressInt) {
                    createChangeProgressActionMessage(t, progressInt);
                }
                task = new hackaton.model.Task(taskId, title, description, Priority.valueOf(priority),
                        progressInt, t.getDateCreated(), deadlineDate, sta, typ);
            } else {
                task = new hackaton.model.Task(null, title, description, Priority.valueOf(priority),
                        0, new Date(), deadlineDate, sta, typ);
            }
            new DAOImpl().newTask(task);
            //map.put("task", task);
            hackaton.model.User loginUser = new LoginController(new DAOImpl() ).getUser();
          
            Ownership ownership = new Ownership(null, OwnershipType.OWNER, loginUser, task);
             new DAOImpl().storeOwnership(ownership);
        
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
        Long taskId = -1L;
        try {
            taskId = Long.valueOf(id);
        } catch (NumberFormatException ex) {
        }
        DAO dao = new DAOImpl();
        hackaton.model.Task task = dao.getTask(taskId);
        Map<String, Object> map = new HashMap<String, Object>();
        List<Comment> commentToTask = dao.getCommentToTask(taskId);
        
        Collections.sort(commentToTask, new Comparator<Comment>() {
            public int compare(Comment o1, Comment o2) {
                return o1.getCreated().compareTo(o2.getCreated());
            }
        });
        map.put("comments", commentToTask);
        map.put("task", dao.getTask(taskId));
        return Response.ok(new Viewable("/task", map)).build();
    }
    
    @POST
    @Path("/{id}/commet")
    public Response postComment(@PathParam("id") Long id, @FormParam("text") String text) {
        DAO dao = new DAOImpl();
        User user = new LoginController(dao).getUser();
        Ownership ownership = dao.getOwnershipForTaskByUser(id, user.getId());
        createMessage(text, ownership, CommentType.MESSAGE);
        return showTask(String.valueOf(id));
    }
    
    private void createChangeStateActionMessage(Task t, State sta) {
        DAO dao = new DAOImpl();
        User user = new LoginController(dao).getUser();
        Ownership ownership = dao.getOwnershipForTaskByUser(t.getId(), user.getId());
        String text = "Změna stavu z: " + t.getState().getName() + " na: " + sta.getName() + ".";
        createMessage(text, ownership, CommentType.ACTION);
    }
    
    private void createChangeProgressActionMessage(Task t, int progressInt) {
        DAO dao = new DAOImpl();
        User user = new LoginController(dao).getUser();
        Ownership ownership = dao.getOwnershipForTaskByUser(t.getId(), user.getId());
        String text = "Změna progressu z: " + t.getProgress() + " na: " + progressInt + ".";
        createMessage(text, ownership, CommentType.ACTION);
    }
    
    private void createMessage(String text, Ownership ownership, CommentType type) {
        Comment comment = new Comment(null, text, new Date(), ownership, type);
        new DAOImpl().storeComment(comment);
    }
}
