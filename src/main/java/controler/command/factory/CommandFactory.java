package controler.command.factory;

import controler.command.Command;
import controler.command.*;
import controler.command.utils.Operation;
import model.exception.*;
import java.util.HashMap;
import java.util.Map;


public class CommandFactory {

    private static final Map<String, Command> allKnownCommandMap = new HashMap<>();

    static {
        allKnownCommandMap.put(Operation.LOGIN, new LoginCommand());
        allKnownCommandMap.put(Operation.REGISTRATION, new RegistrationCommand());
        allKnownCommandMap.put(Operation.LOGOUT, new LogoutCommand());
        allKnownCommandMap.put(Operation.ADMIN_MENU, new AdminPageCommand());
        allKnownCommandMap.put(Operation.PERSON_MENU, new PersonPageCommand());
        allKnownCommandMap.put(Operation.MAIN_MENU, new MainPageCommand());
        allKnownCommandMap.put(Operation.LIST_PERSON, new ListPersonCommand());
        allKnownCommandMap.put(Operation.LIST_BOOK, new ListBookCommand());
        allKnownCommandMap.put(Operation.PERSON_BOOKS, new PersonBookPageCommand());
        allKnownCommandMap.put(Operation.PERSON_PROFILE, new PersonProfilePageCommand());
    }


    public static Command getCommand(String url) throws NotFoundOperationException {
        Command command = allKnownCommandMap.get(url);

        if (command == null) {
            throw new NotFoundOperationException();
        }

        return command;
    }
}
