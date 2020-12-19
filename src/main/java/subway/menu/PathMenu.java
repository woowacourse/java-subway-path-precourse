package subway.menu;

import java.util.Arrays;
import subway.controller.SubwayController;
import subway.exception.SubwayException;
import subway.view.OutputView;

public enum PathMenu {
    DISTANCE("1", "1. 최단 거리", SubwayController::findMinimumDistance),
    TIME("2", "2. 최소 시간",SubwayController::findMinimumTime),
    BACK("B","B. 돌아가기",()->{});



    private final String category;
    private final String menu;
    private final Runnable handler;

    PathMenu(String category, String menu, Runnable handler) {
        this.category = category;
        this.menu = menu;
        this.handler = handler;
    }

    public static void startManage() {
        OutputView.printMainScreen();
        Arrays.stream(values())
            .forEach(value -> System.out.println(value.menu));
    }

    public static void execute(String inputCategory) {
        Arrays.stream(values())
            .filter(value -> value.category.equals(inputCategory.toUpperCase()))
            .findFirst()
            .orElseThrow(() -> new SubwayException("잘못된 값을 입력했습니다."))
            .handler
            .run();
        startManage();
    }
}
