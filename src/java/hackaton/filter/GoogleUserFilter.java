package hackaton.filter;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import hackaton.controller.LoginController;
import hackaton.model.DAOImpl;
import hackaton.model.User;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoogleUserFilter implements Filter {

    public void init(FilterConfig fc) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;


        UserService userService = UserServiceFactory.getUserService();

        String thisURL = httpRequest.getRequestURI();

        httpResponse.setContentType("text/html");
        if (httpRequest.getUserPrincipal() != null) {
            User user = new LoginController(new DAOImpl()).getUser();
            if (user != null) {
                filterChain.doFilter(request, response);
                return;
            }
            httpResponse.getWriter().println("<p>Hello, " +
                                     httpRequest.getUserPrincipal().getName() +
                                     "!  You can <a href=\"" +
                                     userService.createLogoutURL(thisURL) +
                                     "\">sign out</a>.</p>");
            return;
        } else if (thisURL.contains("login")) {
            filterChain.doFilter(request, response);
            return;
        } else {
            String createLoginURL = userService.createLoginURL(thisURL);
            httpResponse.
                        getWriter().println("<p>Please <a href=\""
                                + createLoginURL
                                + "\">sign in</a>.</p>");
            return;
        }
    }

    public void destroy() {
    }
}
