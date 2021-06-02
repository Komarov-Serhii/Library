package controler.command;

import controler.command.utils.CommandUtil;
import model.Book;
import model.Person;
import model.exception.DataBaseException;
import model.exception.ServiceException;
import service.BookService;
import service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.logging.Logger;

public class PersonOrderPageCommand implements Command {
    Logger logger = Logger.getLogger(String.valueOf(PersonBookPageCommand.class));

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {

        ServiceFactory factory = ServiceFactory.getInstance();
        BookService bookService = factory.getBookService();
        Person person = (Person) req.getSession().getAttribute("person");


        String button = req.getParameter("button");



        if (button != null && button.equals("decline")) {
            int id = Integer.parseInt(req.getParameter("id"));
            try {
                Book book = bookService.getEntity(id);
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

        logger.info("in page personPage");


        CommandUtil.goToPage(req, resp, "/WEB-INF/view/personOrderPage.jsp");
    }
}
