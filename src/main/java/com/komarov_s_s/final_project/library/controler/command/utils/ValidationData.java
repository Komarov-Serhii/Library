package com.komarov_s_s.final_project.library.controler.command.utils;

public class ValidationData {

    public static boolean  isLoginValid(String login) {
        final String regex = "[A-Zа-яА-Яa-z0-9-]+";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(regex);
        java.util.regex.Matcher m = p.matcher(login);
        return m.matches();

    }

    public static boolean  isPasswordValid(String password) {
        final String regex = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,15}";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(regex);
        java.util.regex.Matcher m = p.matcher(password);
        return m.matches();
    }

    public static boolean isEmailValid(String email){
        final String regex = "^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;" +
                ":\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\." +
                "[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(regex);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
}
