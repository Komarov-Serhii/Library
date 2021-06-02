package controler.command;

import controler.command.utils.CommandUtil;
import controler.command.utils.Utils;
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

public class PersonBookPageCommand implements Command {

    Logger logger = Logger.getLogger(String.valueOf(PersonBookPageCommand.class));

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        Person person = (Person) req.getSession().getAttribute("person");
        ServiceFactory factory = ServiceFactory.getInstance();
        BookService bookService = factory.getBookService();


        String button = req.getParameter("return");


        if (button != null && button.equals("return")) {

                logger.info("Successful return book");

        }


            List<Book> list = bookService.getAllBooksByPersonID(person.getId());

            req.setAttribute("books", list);

            logger.info("in page personPage");


        CommandUtil.goToPage(req, resp, "/WEB-INF/view/personBookPage.jsp");
    }
}


