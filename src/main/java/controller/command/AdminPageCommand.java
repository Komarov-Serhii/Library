package controller.command;

import controller.command.utils.CommandUtil;
import model.entity.Book;
import model.entity.Person;
import model.exception.ServiceException;
import org.apache.log4j.Logger;
import service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AdminPageCommand implements Command {

    Logger logger = Logger.getLogger(AdminPageCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        var factory = ServiceFactory.getInstance();
        var bookService = factory.getBookService();
        var personService = factory.getPersonService();

        try {

            List<Person> list = personService.getAllFree();
            List<Book> books = bookService.getAllOrder();
            List<Book> allBooks = bookService.getAll();
            List<Book> allBusyBooks = bookService.getAllBusyBooks();

            req.setAttribute("people", list.size());
            req.setAttribute("active", list.size() - factory.getPersonService().getAllBlocked());
            req.setAttribute("blocked", factory.getPersonService().getAllBlocked());
            req.setAttribute("books", allBooks.size());
            req.setAttribute("booksBusy", allBusyBooks.size());
            req.setAttribute("order", books.size());

        } catch (ServiceException e) {
            logger.error("serviceException in page admin ");
            CommandUtil.goToPage(req, resp, "/WEB-INF/view/admin/adminPage.jsp");
        }
        CommandUtil.goToPage(req, resp, "/WEB-INF/view/admin/adminPage.jsp");
    }
}
