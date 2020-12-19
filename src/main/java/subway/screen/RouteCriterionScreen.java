package subway.screen;

public class RouteCriterionScreen implements Screen{
    private static final String ROUTE_CRITERION_SCREEN_INFO = "경로 기준";
    private static final String[] ROUTE_CRITERION_INFO = {"최단 거리", "최소 시간"};
    
    private static final String INPUT_DEPARTURE_STATION = "출발역을 입력하세요.";
    private static final String INPUT_ARRIVAL_STATION = "도착역을 입력하세요.";

    @Override
    public void printScreen() {
        System.out.println(SHARP + ROUTE_CRITERION_SCREEN_INFO);
        for (int i = 0; i < ROUTE_CRITERION_INFO.length; i++) {
            System.out.println((i + 1) + DOT + ROUTE_CRITERION_INFO[i]);
        }
        System.out.println(BACK);
        System.out.println();
    }
    
    public static void askDepartureStation() {
        System.out.println(SHARP + INPUT_DEPARTURE_STATION);
    }
    
    public static void askArrivalStation() {
        System.out.println(SHARP + INPUT_ARRIVAL_STATION);
    }
}
