package controller.command;

import controller.command.utils.CommandUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Book;
import model.Person;
import model.exception.ServiceException;
import service.factory.ServiceFactory;
import java.util.List;
import org.apache.log4j.Logger;

public class AdminPageCommand implements Command {

    Logger logger = Logger.getLogger(AdminPageCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {

        var factory = ServiceFactory.getInstance();
        var bookService = factory.getBookService();
        var personService = factory.getPersonService();

        try {

        List<Person> list = personService.getAll();
        List<Book> books = bookService.getAllOrder();


        req.setAttribute("people", list.size());
        req.setAttribute("active", list.size() - factory.getPersonService().getAllBlocked());
        req.setAttribute("blocked", factory.getPersonService().getAllBlocked());
        req.setAttribute("order", books.size());


        logger.info("in page admin");
        } catch (ServiceException e) {
            logger.info("serviceException");
            CommandUtil.goToPage(req, resp, "/WEB-INF/view/admin/adminPage.jsp");
        }
            CommandUtil.goToPage(req, resp, "/WEB-INF/view/admin/adminPage.jsp");
    }
}
