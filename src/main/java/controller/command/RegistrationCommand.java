package controller.command;

import controller.command.utils.CommandUtil;
import controller.command.utils.ValidationData;
import model.entity.Person;
import model.exception.AlreadyExistPersonException;
import model.exception.ServiceException;
import model.exception.WrongDataException;
import org.apache.log4j.Logger;
import service.PersonService;
import service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;


public class RegistrationCommand implements Command {

    private static Logger logger = Logger.getLogger(RegistrationCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        logger.info("in registration");
        var factory = ServiceFactory.getInstance();

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if (Objects.nonNull(email) && Objects.nonNull(password)) {
            try {

                if (!ValidationData.isEmailValid(email) || !ValidationData.isPasswordValid(password)) {
                    throw new WrongDataException();
                }

                PersonService personService = factory.getPersonService();

                String name = req.getParameter("name");

                var person = personService.getByLogin(email);

                if (Objects.nonNull(person)) {
                    throw new AlreadyExistPersonException();
                } else {
                    person = new Person.PersonBuilderImpl()
                            .setName(name)
                            .setEmail(email)
                            .build();
                    var encrypt = CommandUtil.encrypt(password);
                    person.setPassword(encrypt.orElseThrow(() -> new Exception()));
                    person.setAccessLevel(2);
                    person.setStatus(1);
                    personService.add(person);

                    req.getSession().setAttribute("person", person);

                    String page = CommandUtil.getPersonPageByRole(person.getAccessLevel());

                    CommandUtil.goToPage(req, resp, page);

                    logger.info("successful registration");
                }
            } catch (ServiceException e) {
                logger.error(e.getMessage());
                req.setAttribute("notFound", true);
                CommandUtil.goToPage(req, resp, "/WEB-INF/view/registration.jsp");
            } catch (WrongDataException e) {
                req.setAttribute("wrongData", true);
                logger.error("Incorrect login or password");
                CommandUtil.goToPage(req, resp, "/WEB-INF/view/registration.jsp");
            } catch (AlreadyExistPersonException e) {
                req.setAttribute("alreadyExist", true);
                logger.error("person already exist");
                CommandUtil.goToPage(req, resp, "/WEB-INF/view/registration.jsp");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        CommandUtil.goToPage(req, resp, "/WEB-INF/view/registration.jsp");
    }
}
