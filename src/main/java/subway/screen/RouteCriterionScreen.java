package subway.screen;

public class RouteCriterionScreen implements Screen{
    private static final String ROUTE_CRITERION_SCREEN_INFO = "경로 기준";
    private static final String[] ROUTE_CRITERION_INFO = {"최단 거리", "최소 시간"};

    @Override
    public void printScreen() {
        System.out.println(SHARP + ROUTE_CRITERION_SCREEN_INFO);
        for (int i = 0; i < ROUTE_CRITERION_INFO.length; i++) {
            System.out.println((i + 1) + DOT + ROUTE_CRITERION_INFO[i]);
        }
        System.out.println(BACK);
        System.out.println();
    }
}
