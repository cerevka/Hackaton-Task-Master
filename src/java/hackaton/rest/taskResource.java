
package hackaton.rest;

import com.sun.jersey.api.view.Viewable;
import hackaton.controller.ParserDate;
import hackaton.model.DAOImpl;
import hackaton.model.Priority;
import java.util.Date;
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

@Path("/task")
public class taskResource {

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response createTask(@FormParam("title") String title,
                               @FormParam("description") String description,
                               @FormParam("deadline") String deadline,
                               @FormParam("priority") String priority,
                               @FormParam("state") String state,
                               @FormParam("type") String type) {

        Map<String, Object> map = new HashMap<String, Object>();
        if(state.equals("") || type.equals("")){
            map.put("error", "type.error");
            map.put("states", new DAOImpl().getAllStates());
            map.put("types", new DAOImpl().getAllTypes());
            return Response.ok(new Viewable("/newTask", map)).build();
        }
        hackaton.model.State sta = new DAOImpl().getState(state);
        hackaton.model.Type typ = new DAOImpl().getType(type);
        Date deadlineDate = new ParserDate().parseDate(deadline);

        if (title.equals("") || description.equals("") || deadline.equals("") || typ == null || sta == null || deadlineDate == null) {
            map.put("error", "type.error");
            map.put("states", new DAOImpl().getAllStates());
            map.put("types", new DAOImpl().getAllTypes());
            return Response.ok(new Viewable("/newTask", map)).build();
        } else {
            hackaton.model.Task task = new hackaton.model.Task(null, title, description, Priority.valueOf(priority),
                    0, new Date(), deadlineDate, sta, typ);
            new DAOImpl().newTask(task);
            //map.put("task", task);
            map.put("states", new DAOImpl().getAllStates());
            map.put("types", new DAOImpl().getAllTypes());
            return Response.ok(new Viewable("/newTask", map)).build();
        }
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getTask() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("states", new DAOImpl().getAllStates());
        map.put("types", new DAOImpl().getAllTypes());
        return Response.ok(new Viewable("/newTask", map)).build();
    }
}
