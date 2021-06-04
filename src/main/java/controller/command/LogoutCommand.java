package controller.command;

import controller.command.utils.CommandUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


public class LogoutCommand implements Command {
    private static Logger logger = Logger.getLogger(LogoutCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        logger.info("logout");

        request.getSession().invalidate();

        CommandUtil.goToPage(request, response, "/view/mainPage");
    }

}
