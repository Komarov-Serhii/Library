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

public class PersonBookPageCommand implements Command {

    Logger logger = Logger.getLogger(PersonBookPageCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        logger.info("in page personPage");
        var person = (Person) req.getSession().getAttribute("person");
        var factory = ServiceFactory.getInstance();
        var bookService = factory.getBookService();

        String button = req.getParameter("button");

        if ("pay".equals(button) || "return".equals(button)) {
            var id = Integer.parseInt(req.getParameter("id"));
            try {
                var book = bookService.getEntity(id);
                book.setStatus(1);
                book.setOrderStatus(1);
                bookService.update(book);
                logger.info("Successful return or pay book");
            } catch (DataBaseException|ServiceException e) {
                logger.info("Error return or pay book");
            }
        }

            List<Book> list = bookService.getAllBooksByPersonIDAndAddDebt(person.getId());

            req.setAttribute("books", list);

        CommandUtil.goToPage(req, resp, "/WEB-INF/view/personBookPage.jsp");
    }
}


