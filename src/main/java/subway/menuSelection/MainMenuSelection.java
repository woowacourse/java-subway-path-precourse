package subway.menuSelection;

public enum MainMenuSelection {
    SEARCH("1", "경로 조회"),
    TERMINATE("Q", "종료");

    private String key;
    private String description;

    MainMenuSelection(String key, String description) {
        this.key = key;
        this.description = description;
    }

}
