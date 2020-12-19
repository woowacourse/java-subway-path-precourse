package subway;

import java.util.Scanner;
import subway.controller.SubwayController;
import subway.view.InputView;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final InputView inputView = new InputView(scanner);
        SubwayController subwayController = new SubwayController(inputView);
        subwayController.run();

    }
}
