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

import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

public class OrderAdminCommand implements Command {

    Logger logger = Logger.getLogger(String.valueOf(OrderAdminCommand.class));

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {

        ServiceFactory factory = ServiceFactory.getInstance();
        BookService bookService = factory.getBookService();


        String button = req.getParameter("button");

        if (Objects.nonNull(button) && button.equals("accept")) {

            logger.info("Update add book");
        }

        if (Objects.nonNull(button) && button.equals("reject")) {
            int id = Integer.parseInt(req.getParameter("id"));
            try {
                Book book = bookService.getEntity(id);
                book.setStatus(1);
                book.setOrderStatus(1);
                bookService.update(book);
                logger.info("Successful reject order");
            } catch (DataBaseException|ServiceException e) {
                e.printStackTrace();
            }
        }

        Map<Person, Book> map = bookService.getAllInfoByOrder();


        req.setAttribute("order", map);

        logger.info("in page order");

        CommandUtil.goToPage(req, resp, "/WEB-INF/view/orderPage.jsp");
    }
}
