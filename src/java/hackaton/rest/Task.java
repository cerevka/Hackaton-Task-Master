package hackaton.rest;

import com.sun.jersey.api.view.Viewable;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Tomáš Čerevka <tomas@cerevka.cz>
 */
@Path("/tasks")
public class Task {
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getTask() {
        Map<String, Object> model = new HashMap<String, Object>();
        TaskOverview task = new TaskOverview("Vyhrát HackatOn", "Dlouhy popis", "obchodní", "probíhá", "#", 44);
        model.put("task", task);
        return Response.ok(new Viewable("/tasks", model)).build();
    }
    
}
