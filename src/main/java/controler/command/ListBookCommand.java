package controler.command;

import controler.command.utils.CommandUtil;
import model.Book;
import model.exception.ServiceException;
import service.BookService;

import service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.logging.Logger;

public class ListBookCommand implements Command {

    Logger logger = Logger.getLogger(String.valueOf(ListBookCommand.class));

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        ServiceFactory factory = ServiceFactory.getInstance();
        BookService bookService = factory.getBookService();

        String button = req.getParameter("button");
        if (button != null && button.equals("delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            boolean b = bookService.delete(id);

            if (b) {
                logger.info("Successful delete book");
            }
        }

        try {
            List<Book> list = bookService.getAll();
            logger.info(list.toString());
            req.setAttribute("books", list);

            logger.info("in page listBook");
        } catch (ServiceException e) {
            logger.info("serviceException");
            CommandUtil.goToPage(req, resp, "/WEB-INF/view/listBook.jsp");
        }

        CommandUtil.goToPage(req, resp, "/WEB-INF/view/listBook.jsp");
    }
}
