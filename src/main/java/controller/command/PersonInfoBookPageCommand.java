package controller.command;

import controller.command.utils.CommandUtil;
import model.Book;
import model.Person;
import service.BookService;
import service.factory.ServiceFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import org.apache.log4j.Logger;


public class PersonInfoBookPageCommand implements Command {

    Logger logger = Logger.getLogger(PersonInfoBookPageCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        Person person = (Person) req.getSession().getAttribute("person");
        var factory = ServiceFactory.getInstance();
        var bookService = factory.getBookService();


            List<Book> list = bookService.getAllBooksByPersonIDAndAddDebt(person.getId());
            List<Book> listOrders = bookService.getAllOrderByPersonID(person.getId());

            int count = 0;
        for (Book book : list) {
            count += book.getDebt();
        }


            req.setAttribute("books", list.size());
            req.setAttribute("orders", listOrders.size());
            req.setAttribute("debt", count);

            logger.info("in page person Info");

        CommandUtil.goToPage(req, resp, "/WEB-INF/view/personInfoBookPage.jsp");
    }
}
