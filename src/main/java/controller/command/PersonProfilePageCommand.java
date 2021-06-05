package controller.command;

import controller.command.utils.CommandUtil;
import model.entity.Person;
import model.exception.DataBaseException;
import model.exception.ServiceException;
import service.factory.ServiceFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;


public class PersonProfilePageCommand implements Command {

    Logger logger = Logger.getLogger(PersonProfilePageCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        var factory = ServiceFactory.getInstance();
        var personService = factory.getPersonService();

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
                person.setPassword(CommandUtil.encrypt(password));
                personService.update(person);
                logger.info("Update info person");

                req.getSession().setAttribute("person", person);
            } catch (DataBaseException|ServiceException e) {
                logger.info("Bad update person");
                CommandUtil.goToPage(req, resp, "/WEB-INF/view/personProfile.jsp");
            }
        }


        CommandUtil.goToPage(req, resp, "/WEB-INF/view/personProfile.jsp");

    }
}
