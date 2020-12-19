package subway.menu;

import java.util.Arrays;
import subway.controller.SubwayController;
import subway.exception.SubwayException;
import subway.view.OutputView;

public enum PathMenu {
    DISTANCE("1", "1. 최단 거리"),
    TIME("2", "2. 최소 시간"),
    BACK("B","B. 돌아가기");



    public final String category;
    private final String menu;

    PathMenu(String category, String menu) {
        this.category = category;
        this.menu = menu;
    }

    public static void startManage() {
        OutputView.printPathScreen();
        Arrays.stream(values())
            .forEach(value -> System.out.println(value.menu));
    }

}
