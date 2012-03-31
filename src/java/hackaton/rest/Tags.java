package hackaton.rest;

import com.sun.jersey.api.view.Viewable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/tags")
public class Tags {
    
    @GET
    public Response getTags() {
        Map<String, Object> model = new HashMap<String, Object>();
        List<TagOverview> l = new ArrayList<TagOverview>();
        l.add(new TagOverview("neco", "00ff00"));
        l.add(new TagOverview("neco", "0000ff"));
        l.add(new TagOverview("neco", "ff0000"));
        model.put("tags", l);
        return Response.ok(new Viewable("/tags", model)).build();
    }
    
}
