package com.komarov_s_s.final_project.library.controler.command;

import com.komarov_s_s.final_project.library.controler.command.utils.CommandUtil;
import com.komarov_s_s.final_project.library.model.Person;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
