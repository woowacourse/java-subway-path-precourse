package subway.view;

import java.util.Arrays;
import java.util.function.Consumer;
import subway.service.DistanceSectionService;
import subway.service.TimeSectionService;

public enum PathFindMenu {
    DISTANCE("1", "최단 거리", (key) -> DistanceSectionService.shortestDistance()),
    TIME("2", "최소 시간", (key) -> TimeSectionService.shortestTime()),
    BACK("B", "돌아가기", (key) -> back());

    private final String key;
    private final String name;
    private final Consumer<String> select;

    PathFindMenu(final String key, final String name, final Consumer<String> select) {
        this.key = key;
        this.name = name;
        this.select = select;
    }

    private static void back() {
    }

    public static PathFindMenu getMenuByInput(String input) {
        return Arrays.stream(values()).filter(menu ->
            menu.key.equals(input))
            .findAny()
            .get();
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public void execute() {
        select.accept(key);
    }
}
