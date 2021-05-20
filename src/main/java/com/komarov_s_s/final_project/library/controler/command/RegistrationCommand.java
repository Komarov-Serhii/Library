package com.komarov_s_s.final_project.library.controler.command;

import com.komarov_s_s.final_project.library.controler.command.utils.CommandUtil;
import com.komarov_s_s.final_project.library.controler.command.utils.ValidationData;
import com.komarov_s_s.final_project.library.exception.NotFoundPersonException;
import com.komarov_s_s.final_project.library.exception.ServiceException;
import com.komarov_s_s.final_project.library.exception.WrongDataException;
import com.komarov_s_s.final_project.library.model.Person;
import com.komarov_s_s.final_project.library.service.PersonService;
import com.komarov_s_s.final_project.library.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistrationCommand implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        ServiceFactory factory = ServiceFactory.getInstance();

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        try {

            if (Objects.isNull(email) && Objects.isNull(password)) {
                throw new WrongDataException();
            }

            if (!ValidationData.isEmailValid(email) || !ValidationData.isPasswordValid(password)) {
                throw new WrongDataException();
            }

            PersonService personService = factory.getUserService();


            String name = req.getParameter("name");

            Person person = new Person(name, email, password);
            person.setAccessLevel(2);
            personService.add(person);
            person = personService.getByLoginAndPass(email, password);

            req.getSession().setAttribute("person", person);

            String page = CommandUtil.getUserPageByRole(person.getAccessLevel());

            CommandUtil.goToPage(req, resp,page);

        } catch (ServiceException e) {
            req.setAttribute("notFound", true);
            CommandUtil.goToPage(req, resp, "/WEB-INF/view/registration.jsp");
        } catch (WrongDataException e) {
            req.setAttribute("wrongData", false);
            CommandUtil.goToPage(req, resp, "/WEB-INF/view/registration.jsp");
        } catch (NotFoundPersonException e) {
            Logger.getLogger(CommandUtil.class.getName()).log(Level.WARNING,"Not found person");
        }
    }
}
