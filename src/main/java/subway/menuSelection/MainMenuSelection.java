package subway.menuSelection;

import subway.Controller.MainController;

public enum MainMenuSelection {
    SEARCH("1", "경로 조회", MainController::run),
    TERMINATE("Q", "종료", MainController::terminate);

    private String key;
    private String description;
    private Function mappedFunction;

    MainMenuSelection(String key, String description, Function mappedFunction) {
        this.key = key;
        this.description = description;
        this.mappedFunction = mappedFunction;
    }
}
