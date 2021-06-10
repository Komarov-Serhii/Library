package controller.command;

import controller.command.utils.CommandUtil;
import model.entity.Book;
import model.entity.Person;
import model.exception.DataBaseException;
import model.exception.ServiceException;
import org.apache.log4j.Logger;
import service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Objects;


public class OrderAdminCommand implements Command {

    Logger logger = Logger.getLogger(OrderAdminCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        logger.info("in orders page");
        Book book;
        var factory = ServiceFactory.getInstance();
        var bookService = factory.getBookService();

        String button = req.getParameter("button");

        if (Objects.nonNull(button) && button.equals("accept")) {
            try {
                book = bookService.getEntity(Integer.parseInt(req.getParameter("id")));
                book.setOrderStatus(2);
                book.setReturnDate(CommandUtil.getNextBill());
                bookService.update(book);
                logger.info("Successful accept order");
            } catch (DataBaseException|ServiceException e) {
                logger.error(e.getMessage());
            }
        }

        if (Objects.nonNull(button) && button.equals("reject")) {
            try {
                book = bookService.getEntity(Integer.parseInt(req.getParameter("id")));
                book.setStatus(1);
                book.setOrderStatus(1);
                bookService.update(book);
                logger.info("Successful reject order");
            } catch (DataBaseException|ServiceException e) {
                logger.error(e.getMessage());
            }
        }

        Map<Book, Person> map = bookService.getAllInfoByOrder();


        req.setAttribute("order", map);

        CommandUtil.goToPage(req, resp, "/WEB-INF/view/admin/orderPage.jsp");
    }
}
