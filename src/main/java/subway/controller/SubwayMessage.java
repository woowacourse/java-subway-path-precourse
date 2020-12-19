package subway.controller;

public enum SubwayMessage {
    MAIN_SCREEN("## 메인 화면\n"
            + "1. 경로 조회\n"
            + "Q. 종료\n\n");

    private String content;

    SubwayMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
