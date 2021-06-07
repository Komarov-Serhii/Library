package controller.command.utils;

import model.entity.Book;
import service.BookService;
import service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;

public final class Utils {

    static Logger logger = Logger.getLogger(Utils.class);

    private Utils() {

    }

    public static void sortBooks(HttpServletRequest req, List<Book> list) {
        String sort = req.getParameter("sort");
        if (Objects.nonNull(sort) && sort.equals("sortName")) {
            list.sort(new Book.NameComparator());
            logger.info("successful sorting by name books");

        }
        if (Objects.nonNull(sort) && sort.equals("sortAuthor")) {
            list.sort(new Book.AuthorComparator());
            logger.info("successful sorting by author books");

        }
        if (Objects.nonNull(sort) && sort.equals("sortPublisher")) {
            list.sort(new Book.PublisherComparator());
            logger.info("successful sorting by publisher books");

        }
        if (Objects.nonNull(sort) && sort.equals("sortPublisherDate")) {
            list.sort(new Book.PublisherDateComparator());
            logger.info("successful sorting by publisher date books");
        }
    }

    public static void search(HttpServletRequest req) {
        logger.info("in search");
        var factory = ServiceFactory.getInstance();
        var bookService = factory.getBookService();

        String text = req.getParameter("search");
        if (Objects.nonNull(text)) {
            List<Book> bookList = bookService.findByAuthorOrName(text);
            if (!bookList.isEmpty()) {
                req.setAttribute("win", true);
                req.setAttribute("list", bookList);
                logger.info("successful search");
            } else {
                req.setAttribute("notFoundSearch", true);
                logger.info("not found search");
            }
        }
    }
}
