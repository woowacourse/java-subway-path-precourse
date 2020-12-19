package subway.utils;

import java.util.InputMismatchException;
import java.util.List;

public class ErrorValidator {
    private final static String ERRORMESSAGE = "[ERROR] ";
    private final static String WRONGUSERINPUT = "잘못된 입력입니다.";

    public static void checkMainSelection(List<String> MAINSELECTLIST, String userSelection){
        if (!MAINSELECTLIST.contains(userSelection)) {
            throw new InputMismatchException(ERRORMESSAGE + WRONGUSERINPUT);
        }
    }
}
