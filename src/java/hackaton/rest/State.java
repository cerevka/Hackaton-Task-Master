package hackaton.rest;

import com.sun.jersey.api.view.Viewable;
import hackaton.model.DAOImpl;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/state")
public class State {

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response createState() {
        
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getStates() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("states", new DAOImpl().getAllStates());
        return Response.ok(new Viewable("/rest/state", model)).build();
    }

}
