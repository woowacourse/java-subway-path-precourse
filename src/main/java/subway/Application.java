package subway;

import subway.controller.PathController;
import subway.domain.path.SubwayMapGraph;
import subway.view.InputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        InputView inputView = new InputView(scanner);
        SubwayMapGraph.initiate();
        PathController pathController = new PathController();
        SubwayMapPathInitializer.loadDefaultData(pathController);
        SubwayMapPathManager subwayMapPathManager = new SubwayMapPathManager(inputView, pathController);
        SubwayMapGraph.initiate();
        subwayMapPathManager.run();
        scanner.close();
    }
}
