package subway.view;

import subway.domain.MainMenuType;

import java.util.Scanner;

public class InputView {
    private static final String MAIN_SCREEN = "## 메인 화면\n1. 경로 조회\nQ. 종료";

    private InputView() {
    }

    public static MainMenuType inputMainMenu(Scanner scanner) {
        try {
            System.out.println(MAIN_SCREEN);
            return MainMenuType.of(scanner.nextLine());
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMainMenu(scanner);
        }
    }
}
