package subway.console;

public class IllegalMenuInputException extends IllegalArgumentException {
    private static final String ERROR_INVALID_MENU_INPUT = "\n잘못된 메뉴 입력입니다.";

    public IllegalMenuInputException() {
        super(ERROR_INVALID_MENU_INPUT);
    }
}
