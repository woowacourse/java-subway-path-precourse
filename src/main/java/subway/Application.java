package subway;

import java.util.Scanner;
import subway.controller.SubwayNavigation;
import subway.view.InputView;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        SubwayNavigation subwayNavigation = new SubwayNavigation();
        InputView inputView = new InputView(scanner);
        subwayNavigation.run();
        scanner.close();
    }
}
