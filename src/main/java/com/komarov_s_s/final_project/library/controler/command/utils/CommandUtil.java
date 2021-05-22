package com.komarov_s_s.final_project.library.controler.command.utils;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class CommandUtil {

    public static void goToPage(HttpServletRequest req, HttpServletResponse resp, String url) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(url);
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            Logger.getLogger(CommandUtil.class.getName()).log(Level.WARNING, e.getMessage(), e);
        }
    }

    public static String getPersonPageByRole(int accessLevel) {
        String page = "";
        switch (accessLevel) {
            case 2:
                page = "/WEB-INF/view/personPage.jsp";
                break;
            case 3:
                page = "/WEB-INF/view/adminPage.jsp";
                break;
            default:
        }
        return page;
    }
}
