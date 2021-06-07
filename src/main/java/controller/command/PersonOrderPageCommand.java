package controller.command;

import controller.command.utils.CommandUtil;
import model.entity.Book;
import model.entity.Person;
import model.exception.DataBaseException;
import model.exception.ServiceException;
import service.factory.ServiceFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import org.apache.log4j.Logger;


public class PersonOrderPageCommand implements Command {
    Logger logger = Logger.getLogger(PersonOrderPageCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        logger.info("in person order page");
        var factory = ServiceFactory.getInstance();
        var bookService = factory.getBookService();
        var person = (Person) req.getSession().getAttribute("person");

        String button = req.getParameter("button");

        if (button != null && button.equals("decline")) {
            try {
                Book book = bookService.getEntity(Integer.parseInt(req.getParameter("id")));
                book.setStatus(1);
                book.setOrderStatus(1);
                bookService.update(book);
                logger.info("Successful decline book");
            } catch (DataBaseException|ServiceException e) {
                e.printStackTrace();
            }
        }

        List<Book> list = bookService.getAllOrderByPersonID(person.getId());

        req.setAttribute("books", list);

        CommandUtil.goToPage(req, resp, "/WEB-INF/view/personOrderPage.jsp");
    }
}
