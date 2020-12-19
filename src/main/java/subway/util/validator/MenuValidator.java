package subway.util.validator;

public class MenuValidator {
    private static final String ERROR = "[ ERROR ] ";
    private static final String MENU_ERROR = "존재하지않는 메뉴입니다.";

    public static boolean isVailableMainMenu(String input) {
        if (input.equals("1") || input.equals("Q")) {
            return true;
        }
        System.out.println(ERROR + MENU_ERROR);
        System.out.println();
        return false;
    }

    public static boolean isVailableRouteSearchMenu(String input) {
        if (input.equals("1") || input.equals("2") || input.equals("B")) {
            return true;
        }
        System.out.println(ERROR + MENU_ERROR);
        System.out.println();
        return false;
    }
}
