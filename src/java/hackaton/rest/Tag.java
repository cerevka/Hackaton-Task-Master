package hackaton.rest;

import hackaton.model.DAO;
import hackaton.model.DAOImpl;
import hackaton.model.Role;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/tag")
public class Tag {
    
    @POST
    public Response updateTag(@FormParam("id") Long id, @FormParam("text") String text, @FormParam("color") String color) {
        DAO dao = new DAOImpl();
        hackaton.model.User user = new hackaton.model.User(1L, "Jmeno", "Prijmeni", "aa", "asda", Role.USER);
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
