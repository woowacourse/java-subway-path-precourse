package subway.menuSelection;

import subway.Controller.MainController;
import subway.menuSelection.exception.NoSuchMenuException;

import java.util.Arrays;

public enum PathStandardSelection {
    DISTANCE("1", "경로 조회", () -> {}),   //dummy function, 업데이트 예정
    TIME("2", "최소 시간", () -> {}),
    BACK("B", "돌아가기", MainController::backToMainScreen);

    private static final String MENU_FORMAT = "%s. %s";

    private String key;
    private String description;
    private Function mappedFunction;

    PathStandardSelection(String key, String description, Function mappedFunction) {
        this.key = key;
        this.description = description;
        this.mappedFunction = mappedFunction;
    }

    private String getKey() {
        return this.key;
    }

    public Function getMappedFunction() {
        return this.mappedFunction;
    }

    public static PathStandardSelection searchByKey(String key) {
        return Arrays.stream(PathStandardSelection.values())
                .filter(menu -> menu.getKey().equals(key))
                .findAny()
                .orElseThrow(NoSuchMenuException::new);
    }

    @Override
    public String toString() {
        return String.format(MENU_FORMAT, this.key, this.description);
    }
}
