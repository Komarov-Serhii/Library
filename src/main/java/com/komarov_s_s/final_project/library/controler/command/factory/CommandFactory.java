package com.komarov_s_s.final_project.library.controler.command.factory;

import com.komarov_s_s.final_project.library.controler.command.*;
import com.komarov_s_s.final_project.library.controler.command.utils.*;
import com.komarov_s_s.final_project.library.exception.*;

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

    }


    public static Command getCommand(String url) throws NotFoundOperationException {
        Command command = allKnownCommandMap.get(url);

        if (command == null) {
            throw new NotFoundOperationException();
        }

        return command;
    }
}
