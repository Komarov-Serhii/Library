package controler.command;

import controler.command.utils.CommandUtil;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Person;
import model.exception.DataBaseException;
import model.exception.ServiceException;
import service.PersonService;
import service.factory.ServiceFactory;

import java.util.List;
import java.util.logging.Logger;

public class ListPersonCommand implements Command {

    Logger logger = Logger.getLogger(String.valueOf(ListPersonCommand.class));

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        int id = 0;
        ServiceFactory factory = ServiceFactory.getInstance();
        PersonService personService = factory.getPersonService();

        String button = req.getParameter("button");
        if (button != null && button.equals("delete")) {
            id = Integer.parseInt(req.getParameter("id"));
            boolean b = personService.delete(id);

            if (b) {
                logger.info("Successful delete");
            }
        }

        try {
        if (button != null && button.equals("block")) {
            id = Integer.parseInt(req.getParameter("id"));
            Person person = personService.getEntity(id);
            person.setStatus(2);
            personService.update(person);
        }
        if (button != null && button.equals("unblock")) {
            id = Integer.parseInt(req.getParameter("id"));
            Person person = personService.getEntity(id);
            person.setStatus(1);
            personService.update(person);
        }
        } catch (DataBaseException e) {
            logger.info("DatabaseException update");
        } catch (ServiceException e) {
            logger.info("DatabaseException update");
        }
        System.out.println(id);

        try {
            List<Person> list = personService.getAllPerson();
            req.setAttribute("people", list);

            logger.info("in page listPerson");
        } catch (ServiceException e) {
            logger.info("serviceException");
            CommandUtil.goToPage(req, resp, "/WEB-INF/view/listPerson.jsp");
        }

        CommandUtil.goToPage(req, resp, "/WEB-INF/view/listPerson.jsp");
    }
}
