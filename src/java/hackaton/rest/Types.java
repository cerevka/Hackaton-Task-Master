
package hackaton.rest;

import com.sun.jersey.api.view.Viewable;
import hackaton.model.DAOImpl;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/types")
public class Types {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getTypes() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("types", new DAOImpl().getAllTypes());
        return Response.ok(new Viewable("/types", model)).build();
    }

}
