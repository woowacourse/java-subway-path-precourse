package subway.menu;

public enum PathMenu {
    DISTANCE("1","1. 최단 거리"),
    TIME("2", "2. 최소 시간"),
    BACK("B","B. 돌아가기");

    private final String option;
    private final String message;

    PathMenu(String option, String message) {
        this.option = option;
        this.message = message;
    }

    public String getOption() {
        return option;
    }

    public String getMessage() {
        return message;
    }
}
