package hackaton.rest;

import com.sun.jersey.api.view.Viewable;
import hackaton.model.DAOImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Tomáš Čerevka <tomas@cerevka.cz>
 */
@Path("/tasks")
public class Tasks {
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getTask() {
        /*Map<String, Object> model = new HashMap<String, Object>();
        ArrayList<TaskOverview> tasks = new ArrayList<TaskOverview>();
        
        ArrayList<TagOverview> tags = new ArrayList<TagOverview>();
        TagOverview tag1 = new TagOverview("Java", "#64d700");
        TagOverview tag2 = new TagOverview("GAE", "#ee3133");
        tags.add(tag1);
        tags.add(tag2);
        
        TaskOverview task1 = new TaskOverview("Vyhrát HackatOn", "<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>", "životní cíl", "probíhá", "#", 57, tags);
        TaskOverview task2 = new TaskOverview("Porazit všechny soupeře", "<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>", "vývoj", "přijato", "#", 31);
        TaskOverview task3 = new TaskOverview("Mít nejhezčí aplikaci", "<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>", "grafika", "skoro hotovo", "#", 99);
        TaskOverview task4 = new TaskOverview("Odladit všechny chyby", "<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>", "vývoj", "reklamace", "#", 5);
        TaskOverview task5 = new TaskOverview("Být nejlepší", "<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>", "obchodní", "probíhá", "#", 45);
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);
        tasks.add(task5);
        
        model.put("tasks", tasks);
        return Response.ok(new Viewable("/tasks", model)).build();*/
        Map<String, Object> model = new HashMap<String, Object>();

        List<TaskOverview> l = new ArrayList<TaskOverview>();
        for(hackaton.model.Task t : new DAOImpl().getAllTasks()){
            l.add(new TaskOverview(t.getTitle(),t.getDescription(), t.getTypeName(), t.getStateName(), "/rest/task/"+t.getId(),t.getProgress()));
        }
        model.put("tasks", l);
        return Response.ok(new Viewable("/tasks", model)).build();
    }
    
}
