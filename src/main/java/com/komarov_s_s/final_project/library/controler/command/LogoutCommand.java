package com.komarov_s_s.final_project.library.controler.command;

import com.komarov_s_s.final_project.library.controler.command.utils.CommandUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.logging.Logger;

public class LogoutCommand implements Command {
    private static Logger logger = Logger.getLogger(String.valueOf(LogoutCommand.class));

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        logger.info("logout");

        request.getSession().invalidate();

        CommandUtil.goToPage(request, response, "/login.jsp");
    }

}
