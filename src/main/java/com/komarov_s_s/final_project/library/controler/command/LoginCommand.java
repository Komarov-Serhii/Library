package com.komarov_s_s.final_project.library.controler.command;

import com.komarov_s_s.final_project.library.controler.command.utils.CommandUtil;
import com.komarov_s_s.final_project.library.exception.NotFoundPersonException;
import com.komarov_s_s.final_project.library.exception.WrongDataException;
import com.komarov_s_s.final_project.library.model.Person;
import com.komarov_s_s.final_project.library.service.PersonService;
import com.komarov_s_s.final_project.library.service.factory.ServiceFactory;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.util.Objects;

public class LoginCommand implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        ServiceFactory factory = ServiceFactory.getInstance();

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (Objects.nonNull(login) && Objects.nonNull(password)) {
            PersonService userService = factory.getPersonService();

            try {
                Person person = userService.getByLoginAndPass(login, password);
                req.getSession().setAttribute("person", person);

                String page = CommandUtil.getPersonPageByRole(person.getAccessLevel());

                CommandUtil.goToPage(req, resp, page);
            } catch (NotFoundPersonException e) {
                req.setAttribute("notFound", true);
                CommandUtil.goToPage(req, resp, "/");
            } catch (WrongDataException e) {
                req.setAttribute("wrongData", true);
                CommandUtil.goToPage(req, resp, "/");
            }

        }
    }
}
