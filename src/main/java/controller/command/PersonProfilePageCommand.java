package controller.command;

import controller.command.utils.CommandUtil;
import controller.command.utils.ValidationData;
import model.entity.Person;
import model.exception.DataBaseException;
import model.exception.ServiceException;
import model.exception.WrongDataException;
import org.apache.log4j.Logger;
import service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PersonProfilePageCommand implements Command {

    Logger logger = Logger.getLogger(PersonProfilePageCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        logger.info("in person profile page");
        var factory = ServiceFactory.getInstance();
        var personService = factory.getPersonService();

        String button = req.getParameter("button");

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (button != null && button.equals("set")) {
            req.setAttribute("tab", true);
            logger.info("Successful set profile");
        }


        if (button != null && button.equals("update")) {
            try {
                if (!ValidationData.isEmailValid(email) || !ValidationData.isPasswordValid(password)) {
                    throw new WrongDataException();
                }
                var encrypt = CommandUtil.encrypt(password);
                Person person = personService.getEntity(Integer.parseInt(req.getParameter("id")));
                person.setName(name);
                person.setEmail(email);
                person.setPassword(encrypt.orElseThrow(() -> new Exception()));
                personService.update(person);

                req.getSession().setAttribute("person", person);
            } catch (DataBaseException|ServiceException e) {
                logger.error("Bad update person" + e.getMessage());
                CommandUtil.goToPage(req, resp, "/WEB-INF/view/personProfile.jsp");
            }catch (WrongDataException e) {
                req.setAttribute("wrongData", true);
                logger.error("Incorrect login or password in myProfile");
                CommandUtil.goToPage(req, resp, "/WEB-INF/view/personProfile.jsp");
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }

        CommandUtil.goToPage(req, resp, "/WEB-INF/view/personProfile.jsp");
    }
}
