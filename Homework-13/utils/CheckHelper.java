package elementary13.utils;

import elementary13.exception.StringFormatException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckHelper {
    public static String phoneNumber(String number) throws StringFormatException {
        Pattern pat = Pattern.compile("^\\+[3][8][0]");
        Matcher mat = pat.matcher(number);
        if (!mat.find()) {
            try {
                throw new StringFormatException();
            } finally {
                System.out.println("Wrong number");
            }
        }
        return number;
    }

    //Зробив перевірку під різні пошти
    public static String mail(String mail) throws StringFormatException {
        Pattern pat = Pattern.compile("[a-zA-z][@][a-z]{3,}[.][a-z]{3,}");
        Matcher mat = pat.matcher(mail);
        if (!mat.find()) {
            try {
                throw new StringFormatException();
            } finally {
                System.out.println("Wrong mail");
            }
        }
        return mail;
    }

    public static String DateOfBirth(String date) throws StringFormatException {
        Pattern pat = Pattern.compile("[1-9]{2}[.][1-9]{2}[.][1-9]{4}");
        Matcher mat = pat.matcher(date);
        if (!mat.find()) {
            try {
                throw new StringFormatException();
            } finally {
                System.out.println("Wrong date");
            }
        }
        return date;
    }
}
