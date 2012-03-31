
package hackaton.rest;

import com.sun.jersey.api.view.Viewable;
import hackaton.model.DAO;
import hackaton.model.DAOImpl;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/commentsTask")
public class CommentToTask {

    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getComments(@PathParam("id") Long id) {
        Map<String, Object> model = new HashMap<String, Object>();
        //model.put("comments", new DAOImpl().getCommentToTask(id));
        model.put("comments", new DAOImpl().getCommentToTask(id));
        model.put("task", new DAOImpl().getTask(id));
        //System.out.println(new DAOImpl().getCommentToTask(id).get(0).getText());
        return Response.ok(new Viewable("/comments", model)).build();
    }
}
