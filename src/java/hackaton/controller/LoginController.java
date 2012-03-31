package hackaton.controller;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import hackaton.model.DAO;
import hackaton.model.User;

public class LoginController {
    
    private final DAO dao;
    
    public LoginController(DAO dao) {
        this.dao = dao;
    }
    
    public User getUser() {
        UserService userService = UserServiceFactory.getUserService();
        com.google.appengine.api.users.User user = userService.getCurrentUser();
        String mail = user.getEmail();
        return dao.getUserByEmail(mail);
    }
    
}
