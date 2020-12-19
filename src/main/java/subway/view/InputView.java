package subway.view;

import java.util.Scanner;
import subway.utils.ScreenGroup;

public class InputView {
    private static final String NEW_LINE = "";
    private static final String INVALID_COMMAND = "[ERROR] 선택할 수 없는 기능입니다.\n";

    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getScreenCommand(String screen, String message) {
        try {
            OutputView.print(message);
            String command = scanner.nextLine();
            OutputView.print(NEW_LINE);
            validateScreenCommand(screen, command);
            return command;
        } catch (Exception e) {
            OutputView.print(e.getMessage());
            return getScreenCommand(screen, message);
        }
    }

    private void validateScreenCommand(String screen, String command) {
        ScreenGroup specificScreen = ScreenGroup.valueOf(screen);

        if (!specificScreen.hasCommands(command)) {
            throw new IllegalArgumentException(INVALID_COMMAND);
        }
    }
}
