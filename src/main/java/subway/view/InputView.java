package subway.view;

import subway.domain.SceneState;

import java.util.Scanner;

public class InputView {
    private static final String NEW_LINE = "\n";
    private static final String MAIN_SCENE = "main_scene_";
    private static final String PATH_SCENE = "path_scene_";

    public static SceneState inputMainSceneChoice(Scanner scanner) {
        System.out.println(NEW_LINE + "## 원하는 기능을 선택하세요.");
        return SceneState.findSceneStateByInput(MAIN_SCENE + scanner.nextLine().toLowerCase());
    }

    public static SceneState inputPathSceneChoice(Scanner scanner) {
        System.out.println(NEW_LINE + "## 원하는 기능을 선택하세요.");
        return SceneState.findSceneStateByInput(PATH_SCENE + scanner.nextLine().toLowerCase());
    }

    public static String inputDepartureStation(Scanner scanner) {
        System.out.println(NEW_LINE + "## 출발역을 입력하세요.");
        return scanner.nextLine();
    }

    public static String inputArrivalStation(Scanner scanner) {
        System.out.println(NEW_LINE + "## 도착역을 입력하세요.");
        return scanner.nextLine();
    }
}
