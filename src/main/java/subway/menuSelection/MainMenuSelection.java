package subway.menuSelection;

import subway.Controller.MainController;

public enum MainMenuSelection {
    SEARCH("1", "경로 조회", () -> {}), //이후 노선 조회 로직으로 이어집니다.
    TERMINATE("Q", "종료", MainController::terminate);

    private static final String MENU_FORMAT = "%s. %s";

    private String key;
    private String description;
    private Function mappedFunction;

    MainMenuSelection(String key, String description, Function mappedFunction) {
        this.key = key;
        this.description = description;
        this.mappedFunction = mappedFunction;
    }

    @Override
    public String toString() {
        return String.format(MENU_FORMAT, this.key, this.description);
    }
}
