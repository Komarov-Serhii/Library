package controler.command.utils;

import controler.command.OrderAdminCommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class CommandUtil {

    static Logger logger = Logger.getLogger(String.valueOf(CommandUtil.class));


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
            case 0:
                page = "/view/mainPage";
                break;
            case 2:
                page = "/view/personPage";
                break;
            case 3:
                page = "/WEB-INF/view/adminPage.jsp";
                break;
            default:
        }
        return page;
    }

    public static Date getNextBill() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 30);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(cal.getTime());
        logger.info(date + "output date");
        return Date.valueOf(date);
    }
}
