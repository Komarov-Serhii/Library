package com.komarov_s_s.final_project.library.controler.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
    void execute(HttpServletRequest req, HttpServletResponse resp);
}
