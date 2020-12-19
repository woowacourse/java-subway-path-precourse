package subway.type;

public enum ScreenType {
    MAIN_SCREEN("## 메인 화면\n"),
    PATH_SHOW("1. 경로 조회\n"),
    QUITTING("Q. 종료\n\n"),

    PATH_CRITERIA_SCREEN("## 경로 기준\n"),
    SHORTEST_DISTANCE("1. 최단 거리\n"),
    SHORTEST_TIME("2. 최단 시간\n"),
    BACK("B. 돌아가기\n\n"),

    OPTION_CHOICE("## 원하는 기능을 선택하세요.");

    private final String screen;

    ScreenType(String screen) {
        this.screen = screen;
    }

    public String getScreen() {
        return screen;
    }
}
