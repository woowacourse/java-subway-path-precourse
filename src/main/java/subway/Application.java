package subway;

import subway.controller.SubwayController;
import subway.controller.SubwayPath;
import subway.view.Presenter;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현

        SubwayPath subwayPath = new SubwayPath();
        Presenter presenter = new Presenter();
        SubwayController subwayController = new SubwayController(subwayPath, scanner, presenter);

        subwayController.run();
    }
}
