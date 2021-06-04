package controller.command.utils;

import model.Book;
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
            Collections.sort(list, new Book.NameComparator());
        }
        if (Objects.nonNull(sort) && sort.equals("sortAuthor")) {
            Collections.sort(list, new Book.AuthorComparator());
        }
        if (Objects.nonNull(sort) && sort.equals("sortPublisher")) {
            Collections.sort(list, new Book.PublisherComparator());
        }
        if (Objects.nonNull(sort) && sort.equals("sortPublisherDate")) {
            Collections.sort(list, new Book.PublisherDateComparator());
        }
    }

    public static void search(HttpServletRequest req) {
        ServiceFactory factory = ServiceFactory.getInstance();
        BookService bookService = factory.getBookService();

        String text = req.getParameter("search");
        if (Objects.nonNull(text)) {
            logger.info("search");
            List<Book> bookList = bookService.findByAuthorOrName(text);
            if (!bookList.isEmpty()) {
                req.setAttribute("win", true);
                req.setAttribute("list", bookList);
            } else {
                req.setAttribute("notFoundSearch",true);
            }
        }
    }
}
