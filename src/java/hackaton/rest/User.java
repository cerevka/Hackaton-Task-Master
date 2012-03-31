package hackaton.rest;

import com.sun.jersey.api.view.Viewable;
import hackaton.model.DAOImpl;
import hackaton.model.Role;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/user")
public class User {

    @GET
    @Path("/{id}")
    public Response getUser(@PathParam("id") Long id) {        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user", new DAOImpl().getUser(id));   
        List<hackaton.model.Task> task = new DAOImpl().getMyTasks(id);               
        List<TaskOverview> l = new ArrayList<TaskOverview>(); 
     //    l.add( new TaskOverview("Vyhrát HackatOn", "Dlouhy popis", "obchodní", "probíhá", "#", 44));
        for(hackaton.model.Task t : task){
            l.add(new TaskOverview(t.getTitle(),t.getDescription(), t.getTypeName(), t.getStateName(), "/rest/task/"+t.getId(),t.getProgress()));
        }
        map.put("tasks", l);
        return Response.ok(new Viewable("/user", map)).build();

    }
  
    
    @POST   
    public Response postUser(@FormParam("first_name") String jmeno,@FormParam("last_name") String prijmeni,@FormParam("email") String email,@FormParam("comment") String comment){
        
        Map<String, Object> map = new HashMap<String, Object>();
        hackaton.model.User u = new hackaton.model.User(null,jmeno,prijmeni,email,comment,Role.USER);
        new DAOImpl().newUser(u);
        map.put("user", u);
        return Response.ok(new Viewable("/user", map)).build();
       
    }
    
    @POST
    @Path("/{id}")
    public Response putUser(@PathParam("id") Long id,@FormParam("first_name") String jmeno,@FormParam("last_name") String prijmeni,@FormParam("email") String email,@FormParam("comment") String comment){
        Map<String, Object> map = new HashMap<String, Object>();
        hackaton.model.User u = new DAOImpl().getUser(id);
        
        u.setFirstname(jmeno);
        u.setSurname(prijmeni);
        u.setEmail(email);
        u.setComment(comment);
        new DAOImpl().newUser(u);
        map.put("user", u);
         List<hackaton.model.Task> task = new DAOImpl().getMyTasks(id);               
        List<TaskOverview> l = new ArrayList<TaskOverview>(); 
     //    l.add( new TaskOverview("Vyhrát HackatOn", "Dlouhy popis", "obchodní", "probíhá", "#", 44));
        for(hackaton.model.Task t : task){
            l.add(new TaskOverview(t.getTitle(),t.getDescription(), t.getTypeName(), t.getStateName(), "/rest/task/"+t.getId(),t.getProgress()));
        }
        map.put("tasks", l);
        return Response.ok(new Viewable("/user", map)).build();
        
    }
}