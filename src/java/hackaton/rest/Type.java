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

@Path("/type")
public class Type {

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response createType(@FormParam("name") String name) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (name.equals("")) {
            map.put("error", "type.error");
            return Response.ok(new Viewable("/newType", map)).build();
        } else {
            hackaton.model.Type type = new hackaton.model.Type(name);
            new DAOImpl().newType(type);
            map.put("type", type);
            return Response.ok(new Viewable("/type", map)).build();
        }
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getType() {
        return Response.ok(new Viewable("/newType")).build();
    }
}
