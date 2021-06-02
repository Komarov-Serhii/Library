package controler.command;

import controler.command.utils.CommandUtil;
import model.Book;
import model.Person;
import model.exception.ServiceException;
import service.BookService;
import service.factory.ItemService;
import service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.logging.Logger;

public class PersonInfoBookPageCommand implements Command {

    Logger logger = Logger.getLogger(String.valueOf(PersonInfoBookPageCommand.class));

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        Person person = (Person) req.getSession().getAttribute("person");
        ServiceFactory factory = ServiceFactory.getInstance();

            BookService bookService = factory.getBookService();
            List<Book> list = bookService.getAllBooksByPersonID(person.getId());
            List<Book> listOrders = bookService.getAllOrderByPersonID(person.getId());

            req.setAttribute("books", list.size());
            req.setAttribute("orders", listOrders.size());
           // req.setAttribute("blocked", factory.getPersonService().getAllBlocked());

            logger.info("in page person Info");

        CommandUtil.goToPage(req, resp, "/WEB-INF/view/personInfoBookPage.jsp");
    }
}
