package controller.command;

import controller.command.utils.CommandUtil;
import model.entity.Book;
import model.entity.Person;
import org.apache.log4j.Logger;
import service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class PersonInfoBookPageCommand implements Command {

    Logger logger = Logger.getLogger(PersonInfoBookPageCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        logger.info("in page person Info");

        Person person = (Person) req.getSession().getAttribute("person");
        var factory = ServiceFactory.getInstance();
        var bookService = factory.getBookService();

        List<Book> list = bookService.getAllBooksByPersonIDAndAddDebt(person.getId());
        List<Book> listOrders = bookService.getAllOrderByPersonID(person.getId());

        int count = 0;
        count += list.stream().mapToInt(Book::getDebt).sum();


        req.setAttribute("books", list.size());
        req.setAttribute("orders", listOrders.size());
        req.setAttribute("debt", count);

        CommandUtil.goToPage(req, resp, "/WEB-INF/view/personInfoBookPage.jsp");
    }
}
