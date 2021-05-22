package com.komarov_s_s.final_project.library.controler.servlet;

import com.komarov_s_s.final_project.library.controler.command.Command;
import com.komarov_s_s.final_project.library.controler.command.factory.CommandFactory;
import com.komarov_s_s.final_project.library.controler.command.utils.CommandUtil;
import com.komarov_s_s.final_project.library.exception.NotFoundOperationException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

public class DispatcherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType ("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        String path = req.getRequestURI();
        path = path.substring(path.indexOf("view") - 1);

        Command command = null;
        try {
            command = CommandFactory.getCommand(path);
            command.execute(req, resp);
        } catch (NotFoundOperationException e) {
            CommandUtil.goToPage(req, resp, "/login.jsp");
        }
    }
}
