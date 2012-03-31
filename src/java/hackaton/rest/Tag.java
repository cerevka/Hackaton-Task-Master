package hackaton.rest;

import hackaton.controller.LoginController;
import hackaton.model.DAO;
import hackaton.model.DAOImpl;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path("/tag")
public class Tag {
    
    @POST
    public Response updateTag(@FormParam("id") Long id, @FormParam("text") String text, @FormParam("color") String color, @Context HttpServletResponse response, @Context HttpServletRequest request) throws URISyntaxException, IOException {
        DAO dao = new DAOImpl();
        hackaton.model.User user = new LoginController(dao).getUser();
        if (id == null) {
            dao.storeTag(text, color, user);
        } else {
            hackaton.model.Tag tag = dao.getTag(id);
            tag.setColor(color);
            dao.storeTag(tag);
        }
        return Response.noContent().build();
    }
    
    
    
}
