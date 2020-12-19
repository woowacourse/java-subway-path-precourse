package subway;

import subway.view.InputView;
import subway.view.OutputView;
import subway.view.screen.MainScreen;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        DummyData.save();
        InputView inputView = new InputView(scanner);
        start(inputView);
    }

    public static void start(InputView inputView) {
        while (StatusType.isContinue()) {
            try {
                MainScreen mainScreen = new MainScreen();
                mainScreen.show();
                mainScreen.logic(inputView);
            } catch (RuntimeException e) {
                OutputView.printlnError(e.getMessage());
            }
        }
    }
}
