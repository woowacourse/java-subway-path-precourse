package subway.utils;

public class OutputUtils {
    private final static String INFORMATION = "[INFO] ";
    private final static String ERROR = "[ERROR] ";
    private final static String NEW_LINE = "\n";

    public static void mainMenu(){
        System.out.println("## 메인 화면");
        System.out.println("1. 경로 조회");
        System.out.println("Q. 종료"+NEW_LINE);
    }

    public static void routeInquiryMenu(){
        System.out.println("## 경로 기준");
        System.out.println("1. 최단 거리");
        System.out.println("2. 최소 시간");
        System.out.println("B. 돌아가기"+NEW_LINE);
    }


    public static void selectMenu(){
        System.out.println("## 원하는 기능을 선택하세요.");
    }

    public static void invalidMenuError() {
        System.out.println(NEW_LINE+ERROR+"올바른 메뉴 입력이 아닙니다."+NEW_LINE);
    }

    public static void newline() { System.out.printf(NEW_LINE); }
}
