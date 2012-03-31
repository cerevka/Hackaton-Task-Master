package hackaton.rest;

import com.sun.jersey.api.view.Viewable;
import hackaton.model.DAOImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/tasksCeeelle")
public class taskAllResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getAllTasks() {
        Map<String, Object> model = new HashMap<String, Object>();

        List<TaskOverview> l = new ArrayList<TaskOverview>(); 
        for(hackaton.model.Task t : new DAOImpl().getAllTasks()){
            l.add(new TaskOverview(t.getTitle(),t.getDescription(), t.getTypeName(), t.getStateName(), "/rest/task/"+t.getId(),t.getProgress(), t.getPriority()));
        }
        model.put("tasks", l);
        return Response.ok(new Viewable("/tasks", model)).build();
    }
}
