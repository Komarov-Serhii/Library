package controller.command;

import controller.command.utils.CommandUtil;
import controller.command.utils.Utils;
import model.Book;
import model.Person;
import model.exception.DataBaseException;
import model.exception.ServiceException;
import service.factory.ServiceFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import org.apache.log4j.Logger;


public class ListBookCommand implements Command {

    Logger logger = Logger.getLogger(ListBookCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        var factory = ServiceFactory.getInstance();
        var bookService = factory.getBookService();


        String button = req.getParameter("button");


        if (button != null && button.equals("delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            boolean b = bookService.delete(id);

            if (b) {
                logger.info("Successful delete book");
            }
        }

        if (button != null && button.equals("add")) {
            req.setAttribute("window", true);
            logger.info("Successful open window add");
        }

        if (button != null && button.equals("addSubmit")) {
            String name = req.getParameter("name");
            String author = req.getParameter("author");
            String publisher = req.getParameter("publisher");
            String publisher_date = req.getParameter("publisher_date");
            String description = req.getParameter("description");
            int price = Integer.parseInt(req.getParameter("price"));
            String genre = req.getParameter("genre");

            Book book = new Book(name, author, publisher, publisher_date, description, price, genre);
            book.setStatus(1);
            Person person = (Person) req.getSession().getAttribute("person");
            book.setPerson_id(person.getId());
            book.setOrderStatus(1);
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
            String name = req.getParameter("name");
            String author = req.getParameter("author");
            String publisher = req.getParameter("publisher");
            String publisher_date = req.getParameter("publisher_date");
            String description = req.getParameter("description");
            int price = Integer.parseInt(req.getParameter("price"));
            String genre = req.getParameter("genre");


            try {
                Book book = bookService.getEntity(id);
                book.setName(name);
                book.setAuthor(author);
                book.setPublisher(publisher);
                book.setPublisher_date(publisher_date);
                book.setDescription(description);
                book.setPrice(price);
                book.setGenre(genre);

                bookService.update(book);

                logger.info("Update add book");
            } catch (DataBaseException|ServiceException e) {
                e.printStackTrace();
            }
        }


        try {
            List<Book> list = bookService.getAll();

            Utils.sortBooks(req, list);

            req.setAttribute("books", list);

            logger.info("in page listBook");
        } catch (ServiceException e) {
            logger.info("serviceException");
            CommandUtil.goToPage(req, resp, "/WEB-INF/view/listBook.jsp");
        }

        CommandUtil.goToPage(req, resp, "/WEB-INF/view/listBook.jsp");
    }
}
