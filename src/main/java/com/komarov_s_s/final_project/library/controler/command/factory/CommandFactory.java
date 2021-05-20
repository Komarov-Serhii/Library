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
//        allKnownCommandMap.put(Operation.REGISTRATION, new RegistrationCommand());
//        allKnownCommandMap.put(Operation.ENTRANT_MENU, new EntrantPageCommand());
//        allKnownCommandMap.put(Operation.UNIVERSITIES, new UniversityCommand());
//        allKnownCommandMap.put(Operation.FACULTIES, new FacultyCommand());
//        allKnownCommandMap.put(Operation.SPECIALITIES, new SpecialityCommand());
//        allKnownCommandMap.put(Operation.REGISTER_USER_FOR_EXAM, new ExamCommand());
//        allKnownCommandMap.put(Operation.EDUCATION_PROGRAMS, new ProgramCommand());
//        allKnownCommandMap.put(Operation.CHOOSE_SPECIALITY, new ChooseProgramCommand());
//        allKnownCommandMap.put(Operation.RATING, new RatingCommand());
//        allKnownCommandMap.put(Operation.LOGOUT, new LogoutCommand());
//
//        allKnownCommandMap.put(Operation.ADMIN_MENU, new AdminPageCommand());
//        allKnownCommandMap.put(Operation.ADMIN_FACULTIES, new AdminFacultyCommand());
//        allKnownCommandMap.put(Operation.ADMIN_SPECIALITIES, new AdminSpecialityCommand());
//        allKnownCommandMap.put(Operation.ENTRANTS_FROM_EXAM, new EntrantsFromExamCommand());
//        allKnownCommandMap.put(Operation.EDIT_ENTRANT, new EditEntrantCommand());

    }


    public static Command getCommand(String url) throws NotFoundOperationException {
        Command command = allKnownCommandMap.get(url);

        if (command == null) {
            throw new NotFoundOperationException();
        }

        return command;
    }
}
