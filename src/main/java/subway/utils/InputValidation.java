package subway.utils;

import java.util.Arrays;
import java.util.List;

public class InputValidation {
    private static final String MAIN_MENU_MIN_NUMBER = "1";
    private static final String MAIN_MENU_EXIT = "Q";
    private static final String STRING_END_MARK = "\n";
    private static final List<String> ROUTE_MENU_NUMBER_LIST = Arrays.asList("1", "2");
    private static final String ROUTE_MENU_BACK = "B";
    private static final String ILLEGAL_ARGUMENT_MSG = "\n[ERROR] 입력과 일치하는 기능이 없습니다.";

    public static String isValidOfInputMainMenu(String functionNumber) {
        if (functionNumber.equals(MAIN_MENU_MIN_NUMBER) || functionNumber.toUpperCase().equals(MAIN_MENU_EXIT)) {
            return functionNumber;
        }
        throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MSG + STRING_END_MARK);
    }

    public static String isValidOfInputRouteMenu(String functionNumber) {
        if (ROUTE_MENU_NUMBER_LIST.contains(functionNumber) || functionNumber.toUpperCase().equals(ROUTE_MENU_BACK)) {
            return functionNumber;
        }
        throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MSG + STRING_END_MARK);
    }
}
