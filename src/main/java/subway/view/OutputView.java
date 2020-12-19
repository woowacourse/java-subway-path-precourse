package subway.view;

public class OutputView {
    public static final String MAIN_SCREEN = "## 메인 화면\n1. 경로 조회\nQ. 종료\n"
        + "\n## 원하는 기능을 선택하세요.";
    public static final String PATH_SEARCH_SCREEN = "## 경로 기준\n1. 최단 거리\n2. 최소 시간 \n"
        + "B. 돌아가기\n\n## 원하는 기능을 선택하세요.";

    public static void print(String message) {
        System.out.println(message);
    }
}
