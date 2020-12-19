package subway.view.pathview;

import java.util.Arrays;
import subway.view.View;
import subway.view.mainview.MainChoice;

public enum PathChoice {
    SHORTEST_DISTANCE("1", "최단 거리", new ShortestPathView()),
    MINIMUN_TIME("2", "최소 시간", new MinTimePathView()),
    BACK("B", "돌아가기", null);

    private final String select;
    private final String name;
    private final View view;

    PathChoice(String select, String name, subway.view.View view) {
        this.select = select;
        this.name = name;
        this.view = view;
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

    public void visitView() {
        this.view.setVisible();
    }

    @Override
    public String toString() {
        return this.select + ". " + this.name;
    }
}
