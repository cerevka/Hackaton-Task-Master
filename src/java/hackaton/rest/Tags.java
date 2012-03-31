package hackaton.rest;

import com.sun.jersey.api.view.Viewable;
import hackaton.controller.LoginController;
import hackaton.model.DAO;
import hackaton.model.DAOImpl;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/tags")
public class Tags {
    
    @GET
    public Response getTags() {
        DAO dao = new DAOImpl();
        hackaton.model.User user = new LoginController(dao).getUser();
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("tags", dao.getAllTagsToUser(user));
        return Response.ok(new Viewable("/tags", model)).build();
    }
    
}
