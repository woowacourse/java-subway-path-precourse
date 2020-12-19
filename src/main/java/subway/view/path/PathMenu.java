package subway.view.path;

import subway.Service.SubwayService;

import java.util.Arrays;
import java.util.function.Supplier;

public enum PathMenu {
    SHORESTDISTANCE("1", "최단 거리", () -> SubwayService.getInstance().searchShortestDistancePath()),
    SHORESTTIME("2", "최소 시간", () -> SubwayService.getInstance().searchShortestTimePath()),
    BACK("B", "돌아가기", () -> SubwayService.getInstance().backup());

    private String key;
    private String title;
    private Supplier<Boolean> expression;

    PathMenu(String key, String title, Supplier<Boolean> expression) {
        this.key = key;
        this.title = title;
        this.expression = expression;
    }

    public boolean request(){
        return expression.get();
    }

    public static PathMenu findMenuByKey(String key) {
        return Arrays.stream(values())
                .filter(menu -> menu.getKey().equals(key))
                .findAny()
                .get();
    }

    public static boolean isValidInput(String input) {
        return Arrays.stream(values())
                .anyMatch(menu -> menu.getKey().equals(input));
    }

    public String getKey() {
        return key;
    }

    public String getTitle() {
        return title;
    }
}
