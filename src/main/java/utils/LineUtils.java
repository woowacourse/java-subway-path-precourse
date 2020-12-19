package utils;

public class LineUtils {
    // TODO 순서 정리하기
    public static final String MAIN_MENU = "## 메인 화면\n"
        + "1. 경로 조회\n"
        + "Q. 종료\n";
    public static final String ERROR_INVALID_TYPE = "[ERROR] 유효한 메뉴가 아닙니다.";
    public static final String PATH_MENU = "## 경로 기준\n"
        + "1. 최단 거리\n"
        + "2. 최소 시간\n"
        + "B. 돌아가기\n";
    public static final String ASK_SELECTION = "\n## 원하는 기능을 선택하세요.";
    public static final String ASK_DEPARTURE = "\n## 출발역을 입력하세요.";
    public static final String ASK_ARRIVAL = "\n## 도착역을 입력하세요.";
    public static final String ERROR_NOT_EXIST = "\n[ERROR] 없는 역 이름입니다.";
    public static final String ERROR_BAD_ARRIVAL = "\n[ERROR] 출발역과 도착역이 동일합니다.";
    public static final String ERROR_NOT_CONNECT = "\n[ERROR] 연결되어 있지 않은 경로입니다.";
}
