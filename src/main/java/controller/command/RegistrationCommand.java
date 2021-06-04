package controller.command;


import at.favre.lib.crypto.bcrypt.BCrypt;
import controller.command.utils.CommandUtil;
import controller.command.utils.ValidationData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.exception.*;
import model.Person;
import service.PersonService;
import service.factory.ServiceFactory;

import java.util.Objects;

import org.apache.log4j.Logger;


public class RegistrationCommand implements Command {

    private static Logger logger = Logger.getLogger(RegistrationCommand.class);


    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        var factory = ServiceFactory.getInstance();

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if (Objects.nonNull(email) && Objects.nonNull(password)) {
            try {

                if (!ValidationData.isEmailValid(email) || !ValidationData.isPasswordValid(password)) {
                    throw new WrongDataException();
                }


                PersonService personService = factory.getPersonService();

                String name = req.getParameter("name");

                Person person = new Person(name, email);
                person.setPassword(CommandUtil.cryptWithMD5(password));
                person.setAccessLevel(2);
                person.setStatus(1);
                personService.add(person);
                person = personService.getByLoginAndPass(email, password);

                req.getSession().setAttribute("person", person);

                String page = CommandUtil.getPersonPageByRole(person.getAccessLevel());

                CommandUtil.goToPage(req, resp, page);

                logger.info(page);

            } catch (ServiceException e) {
                req.setAttribute("notFound", true);
                CommandUtil.goToPage(req, resp, "/WEB-INF/view/registration.jsp");
            } catch (WrongDataException e) {
                req.setAttribute("wrongData", true);
                CommandUtil.goToPage(req, resp, "/WEB-INF/view/registration.jsp");
            } catch (NotFoundPersonException e) {
                logger.info("Not found person");
            }
        }
        CommandUtil.goToPage(req, resp, "/WEB-INF/view/registration.jsp");
    }
}
