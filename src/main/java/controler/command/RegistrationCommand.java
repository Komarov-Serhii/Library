package controler.command;


import controler.command.utils.CommandUtil;
import controler.command.utils.ValidationData;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.exception.*;
import model.Person;
import service.PersonService;
import service.factory.ServiceFactory;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistrationCommand implements Command {

     private static Logger logger = Logger.getLogger(String.valueOf(RegistrationCommand.class));


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

            PersonService personService = factory.getPersonService();

            String name = req.getParameter("firstName");

            Person person = new Person(name, email, password);
            person.setAccessLevel(2);
            person.setStatus(1);
            personService.add(person);
            person = personService.getByLoginAndPass(email, password);

            req.getSession().setAttribute("person", person);

            String page = CommandUtil.getPersonPageByRole(person.getAccessLevel());

            CommandUtil.goToPage(req, resp,page);

            logger.info(page);

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
