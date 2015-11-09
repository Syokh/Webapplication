package education.spring.java.lesson.check;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckLogic {

    public boolean checkUserName(String userNameString){
        Pattern p = Pattern.compile("^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$");
        Matcher m = p.matcher(userNameString);
        return m.matches();
    }

    public boolean checkPassword(String passwordString){
        Pattern p = Pattern.compile("(?=^.{6,}$)(?=.*\\d)(?=.*[a-zA-Z]).*$");
        Matcher m = p.matcher(passwordString);
        return m.matches();
    }

}
