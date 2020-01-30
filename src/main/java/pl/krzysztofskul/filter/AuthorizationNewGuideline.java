package pl.krzysztofskul.filter;

import org.springframework.web.filter.GenericFilterBean;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/guidelines/new")
public class AuthorizationNewGuideline extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        Long conceptId = Long.parseLong(request.getParameter("conceptId"));
        String conceptStatus = request.getParameter("conceptStatus");

        if (conceptStatus.equals("FINISHED")) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).sendRedirect("/guidelines/errorStatus");
        }

    }
}
