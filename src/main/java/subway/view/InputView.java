package subway.view;

import java.util.Scanner;

public abstract class InputView {
    protected final Scanner scanner;
    protected static final String PLEASE_INPUT_COMMAND = "## 원하는 기능을 선택하세요.";

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public abstract String inputCommand();

    public abstract void showOption();
}
