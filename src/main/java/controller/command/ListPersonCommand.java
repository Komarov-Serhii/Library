package controller.command;

import controller.command.utils.CommandUtil;
import model.entity.Book;
import model.entity.Person;
import model.exception.DataBaseException;
import model.exception.ServiceException;
import org.apache.log4j.Logger;
import service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;


public class ListPersonCommand implements Command {

    Logger logger = Logger.getLogger(ListPersonCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        logger.info("in page listPerson");
        int id;
        Person person;
        var factory = ServiceFactory.getInstance();
        var personService = factory.getPersonService();
        var bookService = factory.getBookService();

        String button = req.getParameter("button");

        if (Objects.nonNull(button)) {

            if (button.equals("book")) {
                id = Integer.parseInt(req.getParameter("id"));
                req.setAttribute("win", true);

                List<Book> books = bookService.getAllBooksByPersonIDAndAddDebt(id);
                if (books.size() > 0) {
                    req.setAttribute("books", books);
                } else {
                    req.setAttribute("notBooks", true);
                }
                logger.info("Successful open window list books Person");
            }

            if (button.equals("delete")) {
                id = Integer.parseInt(req.getParameter("id"));
                boolean b = personService.delete(id);

                if (b) {
                    logger.info("Successful delete");
                }
            }

            try {
                if (button.equals("block")) {
                    id = Integer.parseInt(req.getParameter("id"));
                    person = personService.getEntity(id);
                    person.setStatus(2);
                    personService.update(person);
                    logger.info("Successful blocked person");
                }
                if (button.equals("unblock")) {
                    id = Integer.parseInt(req.getParameter("id"));
                    person = personService.getEntity(id);
                    person.setStatus(1);
                    personService.update(person);
                    logger.info("Successful unblocked person");

                }
            } catch (DataBaseException | ServiceException e) {
                logger.info(e.getMessage());
            }
        }

        try {
            List<Person> list = personService.getAllPerson();
            req.setAttribute("people", list);
        } catch (ServiceException e) {
            logger.error(e.getMessage());
            CommandUtil.goToPage(req, resp, "/WEB-INF/view/admin/listPerson.jsp");
        }

        CommandUtil.goToPage(req, resp, "/WEB-INF/view/admin/listPerson.jsp");
    }
}
