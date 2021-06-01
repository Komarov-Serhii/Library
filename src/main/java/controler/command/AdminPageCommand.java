package controler.command;

import controler.command.utils.CommandUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import model.Person;

import model.exception.ServiceException;
import service.BookService;
import service.factory.ItemService;
import service.factory.ServiceFactory;
import java.util.List;
import java.util.logging.Logger;

public class AdminPageCommand implements Command {

    Logger logger = Logger.getLogger(String.valueOf(AdminPageCommand.class));

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {

        ServiceFactory factory = ServiceFactory.getInstance();
        BookService bookService = factory.getBookService();
        try {
        ItemService itemService = factory.getPersonService();

        List<Person> list = itemService.getAll();
        List<Book> books = bookService.getAllOrder();


        req.setAttribute("people", list.size());
        req.setAttribute("active", list.size() - factory.getPersonService().getAllBlocked());
        req.setAttribute("blocked", factory.getPersonService().getAllBlocked());
        req.setAttribute("order", books.size());


        logger.info("in page admin");
        } catch (ServiceException e) {
            logger.info("serviceException");
            CommandUtil.goToPage(req, resp, "/WEB-INF/view/adminPage.jsp");
        }
            CommandUtil.goToPage(req, resp, "/WEB-INF/view/adminPage.jsp");
    }
}
