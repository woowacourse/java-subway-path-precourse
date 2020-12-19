package subway.utils;

public class InputValidation {
    private static final String MAIN_MENU_MIN_NUMBER = "1";
    private static final String MAIN_MENU_EXIT = "Q";
    private static final String STRING_END_MARK = "\n";

    public static String isValidOfInputMainMenu(String functionNumber){
        if (functionNumber.equals(MAIN_MENU_MIN_NUMBER) || functionNumber.toUpperCase().equals(MAIN_MENU_EXIT)){
            return functionNumber;
        }
        throw new IllegalArgumentException("[ERROR] 입력과 일치하는 기능이 없습니다." + STRING_END_MARK);
    }
}
