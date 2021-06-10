package controller.command.utils;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;

public abstract class CommandUtil {

    static Logger logger = Logger.getLogger(CommandUtil.class);

    private CommandUtil() {

    }

    public static void goToPage(HttpServletRequest req, HttpServletResponse resp, String url) {
        var requestDispatcher = req.getRequestDispatcher(url);
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
        var cal = Calendar.getInstance();
        var sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(cal.getTime());
        return Date.valueOf(date);
    }

    public static Date getNextBill() {
        var cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 30);
        var sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(cal.getTime());
        return Date.valueOf(date);
    }

    public static Optional<String> encrypt(String pass) {
        try {
            var messageDigest = MessageDigest.getInstance("SHA-256");

            messageDigest.update(pass.getBytes());

            byte[] digest = messageDigest.digest();
            var stringBuilder = new StringBuilder();

            for (byte theByte : digest) {
                stringBuilder.append(String.format("%02x", theByte & 0xff));
            }
            return Optional.of(stringBuilder.toString());
        } catch (NoSuchAlgorithmException e) {
            logger.info(e.getMessage());
        }
        return Optional.empty();
    }
}
