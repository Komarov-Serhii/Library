package controler.command;

import controler.command.utils.CommandUtil;
import model.Book;
import model.Person;
import model.exception.DataBaseException;
import model.exception.ServiceException;
import service.PersonService;
import service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;


public class PersonProfilePageCommand implements Command {

    Logger logger = Logger.getLogger(String.valueOf(PersonProfilePageCommand.class));

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        ServiceFactory factory = ServiceFactory.getInstance();
        PersonService personService = factory.getPersonService();

        String button = req.getParameter("button");

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (button != null && button.equals("set")) {
            req.setAttribute("tab", true);
            logger.info("Successful set profile");
        }


        if (button != null && button.equals("update")) {
            int id = Integer.parseInt(req.getParameter("id"));

            try {
                Person person = personService.getEntity(id);

                person.setName(name);
                person.setEmail(email);
                person.setPassword(password);
                personService.update(person);
                logger.info("Update info person");
            } catch (DataBaseException|ServiceException e) {
                logger.info("Bad update person");
                CommandUtil.goToPage(req, resp, "/WEB-INF/view/personProfile.jsp");
            }
        }
        CommandUtil.goToPage(req, resp, "/WEB-INF/view/personProfile.jsp");

    }
}
