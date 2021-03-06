package hackaton.rest;


import com.sun.jersey.api.view.Viewable;
import hackaton.controller.LoginController;
import hackaton.model.DAOImpl;
import hackaton.model.Ownership;
import hackaton.model.OwnershipType;
import hackaton.model.Task;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author adam
 */
@Path("/taskByUser")
public class TaskByUser {
    
     @GET
     @Path("/{param}")
     public Response getTaskByUser(@PathParam("param") int param) {
         Map<String, Object> map = new HashMap<String, Object>();
         Long userId = new LoginController(new DAOImpl() ).getUser().getId();
        List<Task> l = new DAOImpl().getMyTasks(userId);
        List<TaskOverview> result = new ArrayList<TaskOverview>();
    if(param==1){//user je tvurce tasku        
        for(Task t : l){
          List<Ownership> ownList =  new DAOImpl().getOwnershipsForTaskByUser(t.getId(), userId);
         for(Ownership ow : ownList)
          if(ow.getType() == OwnershipType.OWNER){
             result.add(new TaskOverview(t.getTitle(),t.getDescription(), t.getTypeName(), t.getStateName(), "/rest/task/"+t.getId(),t.getProgress(),t.getPriority()));
             
          }
       break; }
    }
     if(param==2){//user je tvurcem prirazen k tasku      
         for(Task t : l){
          List<Ownership> ownList =  new DAOImpl().getOwnershipsForTaskByUser(t.getId(), userId);
         for(Ownership ow : ownList)
          if(ow.getType() == OwnershipType.ASSIGNED){
             result.add(new TaskOverview(t.getTitle(),t.getDescription(), t.getTypeName(), t.getStateName(), "/rest/task/"+t.getId(),t.getProgress(),t.getPriority()));
             
          }
        break;}
    }
      if(param==3){//user je dobrovolnik tasku       
         for(Task t : l){
          List<Ownership> ownList =  new DAOImpl().getOwnershipsForTaskByUser(t.getId(), userId);
         for(Ownership ow : ownList)
          if(ow.getType() == OwnershipType.VOLUNTEER){
             result.add(new TaskOverview(t.getTitle(),t.getDescription(), t.getTypeName(), t.getStateName(), "/rest/task/"+t.getId(),t.getProgress(),t.getPriority()));
            
          }
         break;}
    }
    map.put("tasks", result);     
        
   return Response.ok(new Viewable("/myTasks", map)).build();
   
     }
    
    
}
