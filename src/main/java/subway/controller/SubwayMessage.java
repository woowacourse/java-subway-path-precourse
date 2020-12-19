package subway.controller;

public enum SubwayMessage {
    MAIN_SCREEN("## 메인 화면\n"
            + "1. 경로 조회\n"
            + "Q. 종료\n\n"),
    PATH_SEARCH_SCREEN("## 경로 기준\n"
            + "1. 최단 거리\n"
            + "2. 최소 시간\n"
            + "B. 돌아가기\n\n"),
    SELECT_FUNCTION("## 원하는 기능을 선택하세요.\n"),
    ENTER_DEPARTURE_STATION("## 출발역을 입력하세요.\n"),
    ENTER_ARRIVAL_STATION("## 도착역을 입력하세요.\n"),
    ERROR_SELECT_FUNCTION("[ERROR] 선택할 수 없는 기능입니다.\n\n"),
    ERROR_DISCONNECTED_PATH("[ERROR] 출발역과 도착역이 연결되어 있지 않습니다.\n\n"),
    ERROR_DUPLICATE_STATION("[ERROR] 출발역과 도착역이 동일합니다.\n\n");

    private String content;

    SubwayMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
