package controler.filter;


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
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

//        final HttpServletRequest req = (HttpServletRequest) servletRequest;
//        final HttpServletResponse resp = (HttpServletResponse) servletResponse;
//        final HttpSession session = req.getSession(false);
//
//        User user = (User) session.getAttribute("user");
//
//
//        if (Objects.nonNull(user)) {
//            int accessLevel = user.getAccessLevel();
//            if (accessLevel == Role.ADMIN.getAccessLevel()) {
//                filterChain.doFilter(req, resp);
//            }
//
//        } else {
//            req.getRequestDispatcher("/").forward(req, resp);
//
//        }
    }

    @Override
    public void destroy() {

    }
}
