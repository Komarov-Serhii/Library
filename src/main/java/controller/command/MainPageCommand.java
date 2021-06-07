package controller.command;

import controller.command.utils.CommandUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.command.utils.Utils;
import model.entity.Book;
import model.exception.ServiceException;
import service.factory.ServiceFactory;
import java.util.List;
import org.apache.log4j.Logger;


public class MainPageCommand implements Command {

    Logger logger = Logger.getLogger(MainPageCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        logger.info("in main page");

        var factory = ServiceFactory.getInstance();
        var bookService = factory.getBookService();

        Utils.search(req);

        try {
            List<Book> list = bookService.getAll();

            Utils.sortBooks(req, list);

            req.setAttribute("books", list);

            CommandUtil.goToPage(req, resp, "/WEB-INF/view/mainPage.jsp");
        } catch (ServiceException e) {
            logger.info(e.getMessage());
            CommandUtil.goToPage(req, resp, "/WEB-INF/view/mainPage.jsp");
        }
    }
}
