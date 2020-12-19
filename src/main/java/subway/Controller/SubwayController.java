package subway.Controller;

import views.InputView;
import views.OutputView;

import java.util.Scanner;

public class SubwayController {

    public final Scanner scanner;

    public SubwayController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        while (true) {
            OutputView.mainView();
            String status = InputView.inputFunction(scanner);
            if (status.equals("Q")) {
                break;
            }
        }
    }
}
