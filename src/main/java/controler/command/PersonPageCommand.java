package controler.command;

import controler.command.utils.CommandUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Person;

import java.util.logging.Logger;

public class PersonPageCommand implements Command {

    Logger logger = Logger.getLogger(String.valueOf(PersonPageCommand.class));

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        Person person = (Person) req.getSession().getAttribute("person");
        logger.info("in page person");
        if (person.getAccessLevel() == 2) {
            String page = CommandUtil.getPersonPageByRole(2);
            CommandUtil.goToPage(req, resp, page);

        }
    }
}
