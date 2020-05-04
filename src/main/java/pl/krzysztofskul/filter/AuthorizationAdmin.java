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

@WebFilter(urlPatterns = {"/admin/*"})
public class AuthorizationAdmin extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession httpSession = ((HttpServletRequest) servletRequest).getSession();
        User user = (User) httpSession.getAttribute("userLoggedIn");

        if (user.getBusinessPosition() != UserBusinessPosition.ADMIN) {
            HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
            httpServletResponse.sendRedirect("/");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

}
