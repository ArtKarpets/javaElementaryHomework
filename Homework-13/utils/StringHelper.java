package elementary13.utils;


import elementary13.exception.StringFormatException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringHelper {

    public static String stringConversion(String string, char[] array) throws StringFormatException {
        if (array == null) {
            try {
                throw new NullPointerException();
            } finally {
                System.out.println("Array == null");
            }
        }
        String arrayInString = String.valueOf(array);
        String stringInString = string;
        Pattern pat = Pattern.compile("[a-zA-Z1-9]");
        Matcher matArray = pat.matcher(arrayInString);
        Matcher matString = pat.matcher(string);
        if (matArray.find() || matString.find()) {
            try {
                throw new StringFormatException();
            } finally {
                System.out.println("your string has an incorrect character");
            }
        }
        stringInString = stringInString.toUpperCase();
        arrayInString = arrayInString.toLowerCase();
        stringInString = stringInString.trim();
        arrayInString = arrayInString.trim();
        String twoInOne = stringInString.concat(" ").concat(arrayInString);
        twoInOne = twoInOne.substring(0, 4) + twoInOne.substring(7);
        return twoInOne;
    }
}
