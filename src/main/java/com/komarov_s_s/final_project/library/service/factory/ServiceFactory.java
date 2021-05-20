package com.komarov_s_s.final_project.library.service.factory;

import com.komarov_s_s.final_project.library.model.Person;
import com.komarov_s_s.final_project.library.service.PersonService;
import com.komarov_s_s.final_project.library.service.impl.PersonServiceImpl;

import java.util.logging.Logger;

public class ServiceFactory {

    private static Logger logger = Logger.getLogger(String.valueOf(ServiceFactory.class));

//    private UniversityService universityService = new UniversityServiceImpl();
//    private FacultyService facultyService = new FacultyServiceImpl();
//    private SpecialityService specialityService = new SpecialityServiceImpl();
//    private EducationalProgramService programService = new EducationalProgramServiceImpl();
//    private ExamService examService = new ExamServiceImpl();
    private PersonService personService = new PersonServiceImpl();

    private static ServiceFactory instance;

    public static ServiceFactory getInstance() {
        if (instance == null) {
            logger.info("Create ServiceFactory");
            instance = new ServiceFactory();
        }
        return instance;
    }

    private ServiceFactory() {

    }


//    public UniversityService getUniversityService() {
//        logger.info("Get UniversityServiceImpl");
//        return universityService;
//    }
//
//
//    public FacultyService getFacultyService() {
//        logger.info("Get FacultyServiceImpl");
//        return facultyService;
//    }
//
//
//    public SpecialityService getSpecialityService() {
//        logger.info("Get SpecialityServiceImpl");
//        return specialityService;
//    }
//
//
//    public EducationalProgramService getEducationalProgramService() {
//        logger.info("Get EducationProgramServiceImpl");
//        return programService;
//    }
//
//
//    public ExamService getExamService() {
//        logger.info("Get ExamServiceImpl");
//        return examService;
//    }


    public PersonService getUserService() {
        return personService;
    }
}
