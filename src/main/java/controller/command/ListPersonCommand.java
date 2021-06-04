package controller.command;

import controller.command.utils.CommandUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.command.utils.ValidationData;
import model.Book;
import model.Person;
import model.exception.DataBaseException;
import model.exception.ServiceException;
import model.exception.WrongDataException;
import service.factory.ServiceFactory;
import java.util.List;
import java.util.Objects;
import org.apache.log4j.Logger;


public class ListPersonCommand implements Command {

    Logger logger = Logger.getLogger(ListPersonCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        int id;
        var factory = ServiceFactory.getInstance();
        var personService = factory.getPersonService();
        var bookService = factory.getBookService();


        String button = req.getParameter("button");


        if (button != null && button.equals("book")) {
            id = Integer.parseInt(req.getParameter("id"));
            req.setAttribute("win", true);

            List<Book> books = bookService.getAllBooksByPersonIDAndAddDebt(id);

            req.setAttribute("books", books);
            logger.info("Successful open window list books Person");
        }

        if (button != null && button.equals("delete")) {
            id = Integer.parseInt(req.getParameter("id"));
            boolean b = personService.delete(id);

            if (b) {
                logger.info("Successful delete");
            }
        }





        if (Objects.nonNull(button) && button.equals("addSubmit")) {
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            try {

                if (Objects.isNull(email) && Objects.isNull(password)) {
                    throw new WrongDataException();
                }

                if (!ValidationData.isEmailValid(email) || !ValidationData.isPasswordValid(password)) {
                    throw new WrongDataException();
                }

            } catch (WrongDataException e) {
                req.setAttribute("wrongData", false);
                CommandUtil.goToPage(req, resp, "/WEB-INF/view/admin/listPerson.jsp");
            }


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


        if (Objects.nonNull(button) && button.equals("add")) {
            req.setAttribute("window", true);
            logger.info("Successful open window add");
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
        } catch (DataBaseException | ServiceException e) {
            logger.info("DatabaseException update");
        }

        try {
            List<Person> list = personService.getAllPerson();
            req.setAttribute("people", list);

            logger.info("in page listPerson");
        } catch (ServiceException e) {
            logger.info("serviceException");
            CommandUtil.goToPage(req, resp, "/WEB-INF/view/admin/listPerson.jsp");
        }

        CommandUtil.goToPage(req, resp, "/WEB-INF/view/admin/listPerson.jsp");
    }
}
