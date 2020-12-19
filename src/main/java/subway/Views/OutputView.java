package subway.Views;

public class OutputView {

    private final static String MAINSCREEN = "## 메인 화면";
    private final static String ROUTESEARCHSELECTION = "1. 경로 조회";
    private final static String PROGRAMEXIT = "Q. 종료";

    private final static String ROUTESCREEN = "## 경로 기준";
    private final static String MINDISTANCEROUTE = "1. 최단 거리";
    private final static String MINTIMEROUTE = "2. 최소 시간";
    private final static String BACKOPTION = "B. 돌아가기";

    protected static void printMainSelection() {
        System.out.println(MAINSCREEN);
        System.out.println(ROUTESEARCHSELECTION);
        System.out.println(PROGRAMEXIT);
        System.out.println();
    }

    protected static void printRouteSelection() {
        System.out.println(ROUTESCREEN);
        System.out.println(MINDISTANCEROUTE);
        System.out.println(MINTIMEROUTE);
        System.out.println(BACKOPTION);
        System.out.println();
    }
}
