package controller;

enum PathMenu {
    PIVOT_SHORTEST_DISTANCE("1", "최단 거리"), PIVOT_SHORTEST_TIME("2", "최소 시간"), GO_BACK("B", "돌아가기");

    public static final String MENU_NAME = "## 경로 기준";

    private String value;
    private String action;

    private PathMenu(String value, String action) {
        this.value = value;
        this.action = action;
    }

    public String getValue() {
        return value;
    }

    public String getAction() {
        return action;
    }
}
