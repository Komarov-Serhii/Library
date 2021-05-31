package controler.command;

import controler.command.utils.CommandUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import model.Person;
import model.exception.ServiceException;
import service.BookService;
import service.factory.ServiceFactory;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class PersonPageCommand implements Command {

    Logger logger = Logger.getLogger(String.valueOf(PersonPageCommand.class));

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
//        Person person = (Person) req.getSession().getAttribute("person");
//        logger.info("in page person");
//        if (person.getAccessLevel() == 2) {
//            String page = CommandUtil.getPersonPageByRole(2);
//            CommandUtil.goToPage(req, resp, page);
//
//        }

        ServiceFactory factory = ServiceFactory.getInstance();
        BookService bookService = factory.getBookService();

        String sort = req.getParameter("sort");


        try {
            List<Book> list = bookService.getAll();

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

            req.setAttribute("books", list);

            logger.info("in page listBook");
            CommandUtil.goToPage(req, resp, "/WEB-INF/view/personPage.jsp");
        } catch (ServiceException e) {
            logger.info("serviceException");
            CommandUtil.goToPage(req, resp, "/WEB-INF/view/personPage.jsp");
        }
    }
}
