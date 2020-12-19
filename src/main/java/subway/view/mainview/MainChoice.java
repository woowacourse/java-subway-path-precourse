package subway.view.mainview;

import java.util.Arrays;
import subway.view.View;

public enum MainChoice {
    PATHSERACH("1", "경로 조회"),
    EXIT("Q", "종료");

    private final String select;
    private final String name;

    MainChoice(String select, String name) {
        this.select = select;
        this.name = name;
    }

    public static MainChoice of(String input) {
        return Arrays.stream(MainChoice.values())
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
