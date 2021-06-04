package controller.filter;


import model.Person;
import model.Role;
import org.apache.log4j.Logger;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

public class RoleFilter implements Filter {

    private static Logger logger = Logger.getLogger(RoleFilter.class);


    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) servletRequest;
        final HttpServletResponse resp = (HttpServletResponse) servletResponse;
        final HttpSession session = req.getSession(false);

        Person person = (Person) session.getAttribute("person");

        logger.info("RoleFilter");
        if (Objects.nonNull(person)) {
            if (person.getAccessLevel() == 3) {
                filterChain.doFilter(req, resp);
            }

        } else {
            req.getRequestDispatcher("/view/mainPage").forward(req, resp);

        }
    }
}
