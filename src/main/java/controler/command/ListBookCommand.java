package controler.command;

import controler.command.utils.CommandUtil;
import model.Book;
import model.exception.ServiceException;
import service.BookService;
import service.factory.ServiceFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.logging.Logger;

public class ListBookCommand implements Command {

    Logger logger = Logger.getLogger(String.valueOf(ListBookCommand.class));

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        ServiceFactory factory = ServiceFactory.getInstance();
        BookService bookService = factory.getBookService();

        String button = req.getParameter("button");

        String name = req.getParameter("name");
        String author = req.getParameter("author");
        String publisher = req.getParameter("publisher");
        String publisher_date = req.getParameter("publisher_date");
        String description = req.getParameter("description");
        int price = Integer.parseInt(req.getParameter("price"));
        String genre = req.getParameter("genre");

        if (button != null && button.equals("delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            boolean b = bookService.delete(id);

            if (b) {
                logger.info("Successful delete book");
            }
        }

        if (button != null && button.equals("add")) {
            req.setAttribute("window", true);
            logger.info("Successful delete book");
        }

        if (button != null && button.equals("addSubmit")) {


            Book book = new Book(name, author, publisher, publisher_date, description, price, genre);

            try {
                bookService.add(book);
            } catch (ServiceException e) {
                logger.info("Bad add book");
            }

            logger.info("Successful add book");
        }

        if (button != null && button.equals("set")) {
            req.setAttribute("win", true);
            logger.info("Successful set book");
        }


        if (button != null && button.equals("update")) {
            int id = Integer.parseInt(req.getParameter("id"));

            Book book = new Book(id, name, author, publisher, publisher_date, description, price, genre);

            bookService.update(book);

            logger.info("Update add book");
        }

        try {
            List<Book> list = bookService.getAll();
            logger.info(list.toString());
            req.setAttribute("books", list);

            logger.info("in page listBook");
        } catch (ServiceException e) {
            logger.info("serviceException");
            CommandUtil.goToPage(req, resp, "/WEB-INF/view/listBook.jsp");
        }

        CommandUtil.goToPage(req, resp, "/WEB-INF/view/listBook.jsp");
    }
}
