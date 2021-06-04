package controller.command.utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;

public abstract class CommandUtil {

    static Logger logger = Logger.getLogger(CommandUtil.class);


    public static void goToPage(HttpServletRequest req, HttpServletResponse resp, String url) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(url);
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            logger.info(e);
        }
    }

    public static String getPersonPageByRole(int accessLevel) {
        String page = "";
        switch (accessLevel) {
            case 1:
                page = "/view/mainPage";
                break;
            case 2:
                page = "/view/personPage";
                break;
            case 3:
                page = "/view/admin/adminPage";
                break;
            default:
        }
        return page;
    }

    public static Date getCurrentDate() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(cal.getTime());
        logger.info(date + "output date");
        return Date.valueOf(date);
    }

    public static Date getNextBill() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 30);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(cal.getTime());
        logger.info(date + "output date");
        return Date.valueOf(date);
    }

    public static String cryptWithMD5(String pass) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            byte[] passBytes = pass.getBytes();
            md.reset();
            byte[] digested = md.digest(passBytes);
            var sb = new StringBuffer();
            for (int i = 0; i < digested.length; i++) {
                sb.append(Integer.toHexString(0xff & digested[i]));
            }
            logger.info("successful hash password");
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            logger.info("bad hash password");
        }
        return null;
    }
}
