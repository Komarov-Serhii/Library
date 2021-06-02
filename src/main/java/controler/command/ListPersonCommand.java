package controler.command;

import controler.command.utils.CommandUtil;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controler.command.utils.ValidationData;
import model.Book;
import model.Person;
import model.exception.DataBaseException;
import model.exception.NotFoundPersonException;
import model.exception.ServiceException;
import model.exception.WrongDataException;
import service.PersonService;
import service.factory.ServiceFactory;

import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListPersonCommand implements Command {

    Logger logger = Logger.getLogger(String.valueOf(ListPersonCommand.class));

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        int id;
        ServiceFactory factory = ServiceFactory.getInstance();
        PersonService personService = factory.getPersonService();

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        String button = req.getParameter("button");
        if (button != null && button.equals("delete")) {
            id = Integer.parseInt(req.getParameter("id"));
            boolean b = personService.delete(id);

            if (b) {
                logger.info("Successful delete");
            }
        }

        try{

        if (Objects.isNull(email) && Objects.isNull(password)) {
            throw new WrongDataException();
        }

        if (!ValidationData.isEmailValid(email) || !ValidationData.isPasswordValid(password)) {
            throw new WrongDataException();
        }

        } catch (WrongDataException e) {
            req.setAttribute("wrongData", false);
            CommandUtil.goToPage(req, resp, "/WEB-INF/view/listPerson.jsp");
        }

        if (Objects.nonNull(button) && button.equals("add")) {
            req.setAttribute("window", true);
            logger.info("Successful open window add");
        }

        if (Objects.nonNull(button) && button.equals("addSubmit")) {



            Person person = new Person(name, email, password);
            person.setStatus(1);
            person.setAccessLevel(3);

            try {
                personService.add(person);
            } catch (ServiceException e) {
                logger.info("Bad add person");
            }

            logger.info("Successful add person");
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
        } catch (DataBaseException|ServiceException e) {
            logger.info("DatabaseException update");
        }

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
