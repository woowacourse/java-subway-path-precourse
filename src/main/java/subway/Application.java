package subway;

import subway.controller.MainController;
import subway.controller.PathController;
import subway.view.OutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        OutputView.printMainScreen();
        MainController.run(scanner);
    }
}
