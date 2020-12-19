package subway.view.inputview;

import subway.view.InputView;
import subway.view.utils.InputValidator;

import java.util.Scanner;

public class MainView extends InputView {
    private static MainView mainView;
    private static final String MAIN_VIEW = "## 메인 화면";
    private static final String FIND_PATH = "1. 경로 조회";
    private static final String QUIT = "Q. 종료";
    private static final String INPUT_PATTERN = "^[1Q]$";

    public MainView(Scanner scanner) {
        super(scanner);
    }

    public static MainView getInstance(Scanner scanner) {
        if (mainView == null) {
            mainView = new MainView(scanner);
        }

        return mainView;
    }

    @Override
    public String inputCommand() {
        System.out.println(PLEASE_INPUT_COMMAND);
        String command = super.scanner.nextLine().trim().toUpperCase();
        System.out.println();
        InputValidator.validateEmpty(command);
        InputValidator.validatePattern(INPUT_PATTERN, command);
        return command;
    }

    @Override
    public void showOption() {
        System.out.println(MAIN_VIEW);
        System.out.println(FIND_PATH);
        System.out.println(QUIT);
        System.out.println();
    }
}
