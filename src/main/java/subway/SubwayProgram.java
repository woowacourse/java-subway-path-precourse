package subway;

import subway.domain.MainMenuType;
import subway.view.InputView;

import java.util.Scanner;

public class SubwayProgram {
    private final Scanner scanner;

    public SubwayProgram(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        MainMenuType mainMenuType;
        do {
            mainMenuType = InputView.inputMainMenu(scanner);
        }while (!MainMenuType.END_PROGRAM.equals(mainMenuType));
    }
}
