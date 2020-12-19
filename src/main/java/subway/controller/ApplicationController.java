package subway.controller;

import java.util.Scanner;
import subway.view.InputView;

public class ApplicationController {
    public static void run(Scanner scanner) {
        InputView.setScanner(scanner);
    }
}
