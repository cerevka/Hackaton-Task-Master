package hackaton.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/tag")
public class Tag {
    
    @POST
    public Response updateTag(@FormParam("id") Long id, @FormParam("text") String text, @FormParam("color") String color) {
        System.out.println(id);
        return Response.ok().build();
    }
    
    
    
}
