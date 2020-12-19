package subway;

import java.util.Scanner;
import subway.controller.SubwayController;
import subway.view.UserView;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현

        UserView.defaultScanner(scanner);
        SubwayController program = new SubwayController();
        program.run();

    }
}
