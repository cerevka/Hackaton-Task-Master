package hackaton.rest;

import com.sun.jersey.api.view.Viewable;
import hackaton.model.DAOImpl;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author adam
 */
@Path("/user/edit")
public class UserEdit {
   
    
      
    @GET
    @Path("/{id}")
    public Response getUser(@PathParam("id") Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user", new DAOImpl().getUser(id));   
        
        return Response.ok(new Viewable("/userEdit", map)).build();

    }
}
