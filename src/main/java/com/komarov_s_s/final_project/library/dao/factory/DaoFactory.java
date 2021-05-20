package com.komarov_s_s.final_project.library.dao.factory;

import com.komarov_s_s.final_project.library.dao.BookDao;
import com.komarov_s_s.final_project.library.dao.BookPhotoDao;
import com.komarov_s_s.final_project.library.dao.CartDao;
import com.komarov_s_s.final_project.library.dao.PersonDao;


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

    public abstract CartDao getCartDAO();
}
