package enjean.advent2025.day02;

import java.util.regex.Pattern;

public class IdValidator {

    public static boolean isValid(long id) {
        String idString = String.valueOf(id);
        for (int i = 1; i <= idString.length() / 2; i++) {
            String possiblePattern = idString.substring(0, i);

            Pattern pattern = Pattern.compile("^(" + possiblePattern + "){2}$");
            if (pattern.matcher(idString).find()) {
//                IO.println("Invalid: " + id);
                return false;
            }
        }
        return true;
    }
}
