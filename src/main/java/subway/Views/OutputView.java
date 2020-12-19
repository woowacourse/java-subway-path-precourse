package subway.Views;

import java.util.List;
import java.util.Scanner;

public class OutputView {

    private final static String MAINSCREEN = "## 메인 화면";
    private final static String ROUTESEARCHSELECTION = "1. 경로 조회";
    private final static String PROGRAMEXIT = "Q. 종료";
    private final static String ROUTESCREEN = "## 경로 기준";
    private final static String MINDISTANCEROUTE = "1. 최단 거리";
    private final static String MINTIMEROUTE = "2. 최소 시간";
    private final static String BACKOPTION = "B. 돌아가기";
    private final static String RESULTSCREEN = "## 조회 결과";
    private final static String INFORMATION = "[INFO] ";
    private final static String SPLITLINE = "---";
    private final static String TOTALDISTANCE = "총 거리: %dkm";
    private final static String TOTALTIME = "총 소요 시간: %d분";


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

    protected static void printResultRoute(List<String> resultList) {
        System.out.println(RESULTSCREEN);
        System.out.println(INFORMATION + SPLITLINE);
//        System.out.println(String.format(INFORMATION + TOTALDISTANCE, totalDistance));
//        System.out.println(String.format(INFORMATION + TOTALTIME, totalTime));
//        System.out.println(INFORMATION + SPLITLINE);
        for (String result : resultList) {
            System.out.println(INFORMATION + result);
        }
    }
}
