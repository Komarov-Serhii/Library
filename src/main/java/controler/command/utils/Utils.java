package controler.command.utils;

import model.Book;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Utils {

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


}
