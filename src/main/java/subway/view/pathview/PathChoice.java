package subway.view.pathview;

import java.util.Arrays;
import subway.view.mainview.MainChoice;

public enum PathChoice {
    SHORTEST_DISTANCE("1", "최단 거리"),
    MINIMUN_TIME("2", "최소 시간"),
    BACK("B", "돌아가기");

    private final String select;
    private final String name;

    PathChoice(String select, String name) {
        this.select = select;
        this.name = name;
    }

    public static PathChoice of(String input) {
        return Arrays.stream(PathChoice.values())
            .filter(choice -> choice.getSelect().equals(input))
            .findAny()
            .orElseThrow(() -> {throw new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다. ");});
    }

    public String getSelect() {
        return select;
    }

    @Override
    public String toString() {
        return this.select + ". " + this.name;
    }
}
