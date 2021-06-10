package controller.command;

import controller.command.utils.CommandUtil;
import controller.command.utils.Utils;
import model.entity.Book;
import model.exception.ServiceException;
import org.apache.log4j.Logger;
import service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class MainPageCommand implements Command {

    Logger logger = Logger.getLogger(MainPageCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        logger.info("in main page");

        var factory = ServiceFactory.getInstance();
        var bookService = factory.getBookService();

        Utils.search(req);

        try {
            List<Book> list = bookService.getAllFree();

            Utils.sortBooks(req, list);

            req.setAttribute("books", list);

            CommandUtil.goToPage(req, resp, "/WEB-INF/view/mainPage.jsp");
        } catch (ServiceException e) {
            logger.error(e.getMessage());
            CommandUtil.goToPage(req, resp, "/WEB-INF/view/mainPage.jsp");
        }
    }
}
