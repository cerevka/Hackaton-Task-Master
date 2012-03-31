package hackaton.rest;

import com.sun.jersey.api.view.Viewable;
import hackaton.model.DAOImpl;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
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
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response createState(@FormParam("name") String name) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (name.equals("")) {
            map.put("error", "state.error");
            return Response.ok(new Viewable("/newState", map)).build();
        } else {
            hackaton.model.State state = new hackaton.model.State(name);
            new DAOImpl().newState(state);
            map.put("state", state);
            return Response.ok(new Viewable("/state", map)).build();
        }
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getStates() {
        return Response.ok(new Viewable("/newState")).build();
    }
}
