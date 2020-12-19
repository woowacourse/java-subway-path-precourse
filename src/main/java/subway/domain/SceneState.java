package subway.domain;

import java.util.Arrays;

public enum SceneState {
    MAIN_SCENE("PATH_SCENE_b"),
    PATH_SCENE("MAIN_SCENE_1"),
    DISTANCE_MIN_SCENE("PATH_SCENE_1"),
    TIME_MIN_SCENE("PATH_SCENE_2"),
    QUIT("MAIN_SCENE_q");

    private String value;

    SceneState(String value) {
        this.value = value.toLowerCase();
    }

    public static SceneState findSceneStateByInput(String input) {
        return Arrays.stream(SceneState.values())
                .filter(sceneState -> sceneState.value.equals(input))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
