package subway.view;

import subway.domain.Station;

import java.util.List;

public class OutputView {
    private static final String INFO_MARK = "[INFO] ";
    private static final String SEPARATER = "---";

    public static void printMainMenu() {
        System.out.println("## 메인 화면");
        System.out.println("1. 경로 조회");
        System.out.println("Q. 종료");
        System.out.println();
    }

    public static void printRouteMainMenu() {
        System.out.println("## 경로 기준");
        System.out.println("1. 최단 거리");
        System.out.println("2. 최소 시간");
        System.out.println("B. 돌아가기");
        System.out.println();
    }

    public static void printResults(){
        System.out.println("## 조회 결과");

        /*
        ## 조회 결과
[INFO] ---
[INFO] 총 거리: 6km
[INFO] 총 소요 시간: 14분
[INFO] ---
[INFO] 교대역
[INFO] 강남역
[INFO] 양재역
         */
    }

    private static void printResultsByStationList(List<Station> stations){
        for(Station station: stations){
            System.out.println(INFO_MARK + station.getName());
        }
    }
}
