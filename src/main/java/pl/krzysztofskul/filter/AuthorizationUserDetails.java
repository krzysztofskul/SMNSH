package pl.krzysztofskul.filter;

import org.springframework.web.filter.GenericFilterBean;
import pl.krzysztofskul.user.User;
import pl.krzysztofskul.user.UserBusinessPosition;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/users/details/*")
public class AuthorizationUserDetails extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        User user = (User) session.getAttribute("userLoggedIn");
        String servletPath = ((HttpServletRequest) servletRequest).getServletPath();
        boolean containsPathId = servletPath.contains(user.getId().toString());

        if (user.getBusinessPosition() != UserBusinessPosition.ADMIN && !containsPathId) {
            HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
            httpServletResponse.sendRedirect("/permissionDenied");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }
}