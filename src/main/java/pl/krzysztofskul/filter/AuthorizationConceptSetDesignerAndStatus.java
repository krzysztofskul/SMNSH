package pl.krzysztofskul.filter;

import org.springframework.web.filter.GenericFilterBean;
import pl.krzysztofskul.user.User;
import pl.krzysztofskul.user.UserBusinessPosition;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/concepts/setDesigner/*", "/concepts/setStatus/*"})
public class AuthorizationConceptSetDesignerAndStatus extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        User user = (User) session.getAttribute("userLoggedIn");

        if (user.getBusinessPosition().equals(UserBusinessPosition.PROJECT_MANAGER)) {
            HttpServletResponse httpServletResponse = ((HttpServletResponse) servletResponse);
            httpServletResponse.sendRedirect("/permissionDenied");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }
}
