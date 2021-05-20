package com.komarov_s_s.final_project.library.controler.command.utils;

import com.komarov_s_s.final_project.library.service.impl.PersonServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommandUtil {

    public static void goToPage(HttpServletRequest req, HttpServletResponse resp, String url) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(url);
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            Logger.getLogger(CommandUtil.class.getName()).log(Level.WARNING, e.getMessage(), e);
        }
    }

    public static String getUserPageByRole(int accessLevel) {
        String page = "";
        switch (accessLevel) {
            case 2:
                page = "/WEB-INF/view/entrant_menu.jsp";
                break;
            case 3:
                page = "/WEB-INF/view/admin_menu.jsp";
                break;
            default:
        }
        return page;
    }
}
