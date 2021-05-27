package controler.command;

import controler.command.utils.CommandUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.logging.Logger;

public class LogoutCommand implements Command {
    private static Logger logger = Logger.getLogger(String.valueOf(LogoutCommand.class));

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        logger.info("logout");

        request.getSession().invalidate();

        CommandUtil.goToPage(request, response, "/");
    }

}
