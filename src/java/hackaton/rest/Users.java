package hackaton.rest;

import com.sun.jersey.api.view.Viewable;
import hackaton.model.DAOImpl;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


/**
 *
 * @author adam
 */
@Path("/users")
public class Users {
    
    @GET
    public Response getUsers(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("users", new DAOImpl().getAllUsers());
//        List<User> l = new ArrayList<User>();
//        l.add(new User(new Long(1), "jmeno","Ptijmei", null, null, Role.USER));
//         l.add(new User(new Long(1), "jmeno2","Ptijmei2", null, null, Role.USER));
//        l.add(new User(new Long(1), "jmeno3","Ptijmei3", null, null, Role.USER));
//          map.put("users", map);
        return Response.ok(new Viewable("/users", map)).build();
     
    }
}
