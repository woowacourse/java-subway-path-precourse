package subway;

import subway.controller.PathController;
import subway.domain.path.SubwayGraph;
import subway.view.InputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        InputView inputView = new InputView(scanner);
        SubwayGraph.initiate();
        PathController pathController = new PathController();
        SubwayPathInitializer.loadDefaultData(pathController);
        SubwayPathManager subwayPathManager = new SubwayPathManager(inputView, pathController);
        subwayPathManager.run();
        scanner.close();
    }
}
