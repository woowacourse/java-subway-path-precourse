package subway.menu;

public class NotAccptedMenuInputException extends RuntimeException {
    private static final String ERROR_MESSAGE = "선택할 수 없는 기능입니다.";

    public NotAccptedMenuInputException() {
        super(ERROR_MESSAGE);
    }
}
