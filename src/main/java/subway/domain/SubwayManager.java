package subway.domain;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class SubwayManager {
    public void startProgram(Scanner scanner) {
        SceneState sceneState = SceneState.MAIN_SCENE;

        while (sceneState != SceneState.QUIT) {
            sceneState = viewMainScene(scanner, sceneState);
        }
    }

    private SceneState viewMainScene(Scanner scanner, SceneState sceneState) {
        if (sceneState == SceneState.MAIN_SCENE) {
            OutputView.printMainScene();

            return InputView.inputMainSceneChoice(scanner);
        }

        return sceneState;
    }
}
