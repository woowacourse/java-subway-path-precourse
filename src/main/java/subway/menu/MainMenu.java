package subway.menu;

import java.util.Arrays;
import subway.controller.SubwayController;
import subway.exception.SubwayException;
import subway.view.OutputView;

public enum MainMenu {
    PATH("1", "1. 경로 조회"),
    EXIT("Q", "Q. 종료");

    public final String category;
    private final String menu;

    MainMenu(String category, String menu) {
        this.category = category;
        this.menu = menu;
    }

    public static void startManage() {
        OutputView.printMainScreen();
        Arrays.stream(values())
            .forEach(value -> System.out.println(value.menu));
    }

}
