package hackaton.controller;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import hackaton.model.DAO;
import hackaton.model.Role;
import hackaton.model.User;

public class LoginController {
    
    private final DAO dao;
    
    public LoginController(DAO dao) {
        this.dao = dao;
    }
    
    public User getUser() {
        UserService userService = UserServiceFactory.getUserService();
        com.google.appengine.api.users.User user = userService.getCurrentUser();
        return dao.getUserByEmail(user.getEmail());
    }
    
}
