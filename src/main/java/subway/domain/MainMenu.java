package subway.domain;

import subway.utils.Validator;
import subway.view.InputView;

import java.util.Scanner;

public class MainMenu {
    private static boolean isMainRunFlag = true;

    private static void mainStop() {
        isMainRunFlag = false;
    }

    public static boolean isMainRunning() {
        return isMainRunFlag;
    }

    public static void mainRun(Scanner scanner) {
        try {
            InputView.printMainInput();
            mainInput(scanner);
        } catch (IllegalArgumentException e) {
            System.out.println("\n[ERROR]" + e.getMessage());
        }
    }

    private static void mainInput(Scanner scanner) throws IllegalArgumentException {
        String inputMsg = scanner.nextLine();
        if (!Validator.isValidMainInput(inputMsg)) {
            throw new IllegalArgumentException("선택할 수 없는 기능입니다.");
        }
        mainMenuController(inputMsg, scanner);
    }

    private static void mainMenuController(String inputMsg, Scanner scanner) {
        if (inputMsg.equals("Q")) {
            mainStop();
            return;
        }
        // 경로 조회 창으로 넘어가는 기능 구현

    }
}
