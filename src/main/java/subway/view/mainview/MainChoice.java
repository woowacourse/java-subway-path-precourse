package subway.view.mainview;

import java.util.Arrays;
import subway.view.View;
import subway.view.pathview.PathMenuView;

public enum MainChoice {
    PATHSERACH("1", "경로 조회", new PathMenuView()),
    EXIT("Q", "종료", null);

    private final String select;
    private final String name;
    private final View view;

    MainChoice(String select, String name, View view) {
        this.select = select;
        this.name = name;
        this.view = view;
    }

    public static MainChoice of(String input) {
        return Arrays.stream(MainChoice.values())
            .filter(choice -> choice.getSelect().equals(input))
            .findAny()
            .orElseThrow(() -> {throw new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다. ");});
    }

    public void visitView() {
        this.view.setVisible();
    }

    public String getSelect() {
        return select;
    }

    @Override
    public String toString() {
        return this.select + ". " + this.name;
    }
}
