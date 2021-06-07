package controller.command;

import controller.command.utils.CommandUtil;
import controller.command.utils.Utils;
import model.entity.Book;
import model.entity.Person;
import model.exception.ServiceException;
import org.apache.log4j.Logger;
import service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class PersonPageCommand implements Command {

    Logger logger = Logger.getLogger(PersonPageCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        logger.info("in page person");
        Person person = (Person) req.getSession().getAttribute("person");

        var factory = ServiceFactory.getInstance();
        var bookService = factory.getBookService();

        String button = req.getParameter("button");

        Utils.search(req);

        if (button != null && button.equals("order")) {
            int id_book = Integer.parseInt(req.getParameter("id"));

            bookService.setBookForApprove(id_book, person.getId());

        }
        try {
            List<Book> list = bookService.getAll();

            Utils.sortBooks(req, list);

            req.setAttribute("books", list);

            CommandUtil.goToPage(req, resp, "/WEB-INF/view/personPage.jsp");
        } catch (ServiceException e) {
            logger.error(e.getMessage());
            CommandUtil.goToPage(req, resp, "/WEB-INF/view/personPage.jsp");
        }
    }
}
