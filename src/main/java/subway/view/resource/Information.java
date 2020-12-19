package subway.view.resource;

public class Information {

    public static final String CHOOSE_FUNCTION = "\n## 원하는 기능을 선택하세요.";
    public static final String MAIN_INFO = "## 메인 화면\n1. 경로 조회\nQ. 종료\n" + CHOOSE_FUNCTION;

    public static final String BASIS_INFO = "## 경로 기준\n1. 최단 거리\n2. 최소 시간\nB. 돌아가기\n" + CHOOSE_FUNCTION;
    public static final String SRC_INFO = "## 출발역을 입력하세요";
    public static final String DST_INFO = "## 도착역을 입력하세요";

    public static final String PATH_INFO = "## 조회 결과";
    public static final String PATH_TOTAL_DISTANCE = "총 거리: ";
    public static final String PATH_TOTAL_DISTANCE_KM = "km";
    public static final String PATH_TOTAL_TIME = "총 소요 시간: ";
    public static final String PATH_TOTAL_TIME_MIN = "분";
}
