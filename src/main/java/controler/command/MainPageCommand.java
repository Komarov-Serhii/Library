package controler.command;

import controler.command.utils.CommandUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Person;

import java.util.logging.Logger;

public class MainPageCommand implements Command {

    Logger logger = Logger.getLogger(String.valueOf(MainPageCommand.class));

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        Person person = (Person) req.getSession().getAttribute("person");
        logger.info("in main page");
        if (person.getAccessLevel() == 0) {
            String page = CommandUtil.getPersonPageByRole(0);
            CommandUtil.goToPage(req, resp, page);

        }
    }
}
