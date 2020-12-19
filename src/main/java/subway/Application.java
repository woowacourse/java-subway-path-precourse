package subway;

import java.util.Scanner;
import subway.controller.SubwayPathFindController;
import subway.util.SubwayDataFactory;
import subway.view.InputView;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        InputView.scanner = scanner;

        SubwayDataFactory subwayDataFactory = new SubwayDataFactory();
        subwayDataFactory.makeSubwayData();

        SubwayPathFindController subwayPathFindController = new SubwayPathFindController();
        subwayPathFindController.run();
    }
}
