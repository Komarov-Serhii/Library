package controler.command;

import controler.command.utils.CommandUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Person;

import model.exception.ServiceException;
import service.factory.ItemService;
import service.factory.ServiceFactory;
import java.util.List;
import java.util.logging.Logger;

public class AdminPageCommand implements Command {

    Logger logger = Logger.getLogger(String.valueOf(AdminPageCommand.class));

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {

        ServiceFactory factory = ServiceFactory.getInstance();
        try {
        ItemService itemService = factory.getPersonService();
        List<Person> list = itemService.getAll();

        req.setAttribute("people", list.size());
        req.setAttribute("active", list.size() - factory.getPersonService().getAllBlocked());
        req.setAttribute("blocked", factory.getPersonService().getAllBlocked());

        logger.info("in page admin");
        } catch (ServiceException e) {
            logger.info("serviceException");
            CommandUtil.goToPage(req, resp, "/WEB-INF/view/adminPage.jsp");
        }
            CommandUtil.goToPage(req, resp, "/WEB-INF/view/adminPage.jsp");
    }
}
