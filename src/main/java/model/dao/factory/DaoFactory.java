package model.dao.factory;


import model.dao.*;


public abstract class DaoFactory {

    private static DaoFactory instance;

    public static DaoFactory getInstance() {
        if (instance == null) {
            instance = new DatabaseDaoFactory();
        }
        return instance;
    }


    public abstract PersonDao getPersonDAO();

    public abstract BookDao getBookDAO();

    public abstract BookPhotoDao getBookPhotoDAO();
}
