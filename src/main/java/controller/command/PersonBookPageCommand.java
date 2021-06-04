package controller.command;

import controller.command.utils.CommandUtil;
import model.Book;
import model.Person;
import model.exception.DataBaseException;
import model.exception.ServiceException;
import service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;
import org.apache.log4j.Logger;

public class PersonBookPageCommand implements Command {

    Logger logger = Logger.getLogger(PersonBookPageCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        Person person = (Person) req.getSession().getAttribute("person");
        var factory = ServiceFactory.getInstance();
        var bookService = factory.getBookService();



        String button = req.getParameter("button");


        if (Objects.nonNull(button) && button.equals("return")) {
            int id = Integer.parseInt(req.getParameter("id"));
            try {
                Book book = bookService.getEntity(id);
                book.setStatus(1);
                book.setOrderStatus(1);
                bookService.update(book);
                logger.info("Successful return book");
            } catch (DataBaseException|ServiceException e) {
                logger.info("Error return book");
            }
        }

        if (Objects.nonNull(button) && button.equals("pay")) {
            int id = Integer.parseInt(req.getParameter("id"));
            try {
                Book book = bookService.getEntity(id);
                book.setStatus(1);
                book.setOrderStatus(1);
                book.setDebt(0);
                bookService.update(book);
                logger.info("Successful return book");
            } catch (DataBaseException|ServiceException e) {
                logger.info("Error return book");
            }
        }


            List<Book> list = bookService.getAllBooksByPersonIDAndAddDebt(person.getId());

        for (Book book : list) {
            bookService.update(book);
        }
            req.setAttribute("books", list);

            logger.info("in page personPage");


        CommandUtil.goToPage(req, resp, "/WEB-INF/view/personBookPage.jsp");
    }
}


