package com.opitz.utility;


import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public boolean validateEmail(String email) {

        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
        Matcher m = p.matcher(email);

        boolean matchFound = m.matches();

        if (matchFound)
            return true;
        return false;

    }

    public boolean validateNumber(String number) {

        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(number);

        if (m.matches())
            return true;
        return false;
    }

    public boolean validateDate(String date) {

        Pattern p = Pattern.compile("([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))");
        Matcher m = p.matcher(date);

        if (m.matches())
            return true;
        return false;
    }




}
