package subway.view;

import java.util.List;
import subway.domain.Station;
import subway.utils.Result;

public class OutputView {
    public static final String INFO ="[INFO] ";
    public static final String TOTAL_DISTANCE ="총 거리 : ";
    public static final String KM ="km";
    private static final String SEPARATOR_LINE = "---";
    public static final String MAIN_SCREEN = "## 메인 화면\n1. 경로 조회\nQ. 종료\n"
        + "\n## 원하는 기능을 선택하세요.";
    public static final String PATH_SEARCH_SCREEN = "## 경로 기준\n1. 최단 거리\n2. 최소 시간 \n"
        + "B. 돌아가기\n\n## 원하는 기능을 선택하세요.";
    public static final String ORDER_TO_INPUT_DEPARTURE_STATION = "## 출발역을 입력하세요.";
    public static final String ORDER_TO_INPUT_ARRIVAL_STATION = "## 출발역을 입력하세요.";


    public static void print(String message) {
        System.out.println(message);
    }

    public static void printList(Result result, Station arrivalStation, List<Station> stops, int distance){
        System.out.println("## 조회 결과");
        System.out.println(SEPARATOR_LINE);
        System.out.println(INFO+TOTAL_DISTANCE+distance+KM);
        System.out.println(SEPARATOR_LINE);
        stops.stream()
            .forEach(System.out::println);
        System.out.println();
    }
}
