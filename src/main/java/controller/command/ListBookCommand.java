package controller.command;

import controller.command.utils.CommandUtil;
import controller.command.utils.Utils;
import model.entity.Book;
import model.entity.Person;
import model.exception.DataBaseException;
import model.exception.ServiceException;
import org.apache.log4j.Logger;
import service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;


public class ListBookCommand implements Command {

    Logger logger = Logger.getLogger(ListBookCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        logger.info("in page listBook");
        var factory = ServiceFactory.getInstance();
        var bookService = factory.getBookService();
        Person person = (Person) req.getSession().getAttribute("person");
        Book book;

        String button = req.getParameter("button");

        Utils.search(req);

        if (Objects.nonNull(button)) {

            if (button.equals("delete")) {
                boolean b = bookService.delete(Integer.parseInt(req.getParameter("id")));
                if (b) {
                    logger.info("Successful delete book");
                }
            }

            if (button.equals("add")) {
                req.setAttribute("win1", true);
                logger.info("Successful open window add");
            }

            if (button.equals("addSubmit")) {
                book = new Book.BookBuilderImpl()
                        .setName(req.getParameter("name"))
                        .setAuthor(req.getParameter("author"))
                        .setPublisher(req.getParameter("publisher"))
                        .setPublisherDate(req.getParameter("publisherDate"))
                        .setDescription(req.getParameter("description"))
                        .setPrice(Integer.parseInt(req.getParameter("price")))
                        .setGenre(req.getParameter("genre"))
                        .build();
                book.setStatus(1);
                book.setPerson_id(person.getId());
                book.setOrderStatus(1);
                try {
                    bookService.add(book);
                } catch (ServiceException e) {
                    logger.info("Bad add book");
                }
                logger.info("Successful add book");
            }

            if (button.equals("set")) {
                req.setAttribute("win", true);
                logger.info("Successful set book");
            }

            if (button.equals("update")) {
                try {
                    book = bookService.getEntity(Integer.parseInt(req.getParameter("id")));
                    book.setName(req.getParameter("name"));
                    book.setAuthor(req.getParameter("author"));
                    book.setPublisher(req.getParameter("publisher"));
                    book.setPublisherDate(req.getParameter("publisherDate"));
                    book.setDescription(req.getParameter("description"));
                    book.setPrice(Integer.parseInt(req.getParameter("price")));
                    book.setGenre(req.getParameter("genre"));
                    bookService.update(book);
                    logger.info("Update add book");
                } catch (DataBaseException | ServiceException e) {
                    logger.error(e.getMessage());
                }
            }
        }

        try {
            List<Book> list = bookService.getAllFree();

            Utils.sortBooks(req, list);

            req.setAttribute("books", list);


        } catch (ServiceException e) {
            logger.error(e.getMessage());
            CommandUtil.goToPage(req, resp, "/WEB-INF/view/admin/listBook.jsp");
        }

        CommandUtil.goToPage(req, resp, "/WEB-INF/view/admin/listBook.jsp");
    }
}
