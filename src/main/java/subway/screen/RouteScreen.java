package subway.screen;

import java.util.Arrays;
import subway.controller.SubwayPathController;

public enum RouteScreen implements Screen {

    DISTANCE("1", "최단 거리") {
        @Override
        public Screen run() {
            controller.findByDistance();
            return MainScreen.ROUTE;
        }
    },
    TIME("2", "최소 시간") {
        @Override
        public Screen run() {
            controller.findByTime();
            System.out.println("최소 시간 실행 미구현");
            return MainScreen.ROUTE;
        }
    },
    BACK("Q", "돌아가기") {
        @Override
        public Screen run() {
            //아무것도 하지 않고 MainScreen을 반환한다.
            return MainScreen.ROUTE;
        }
    };

    private static final String SCREEN_TITLE = "경로 기준";
    private static SubwayPathController controller = new SubwayPathController();

    private final String code;
    private final String command;

    RouteScreen(String code, String command) {
        this.code = code;
        this.command = command;
    }

    @Override
    public Screen[] getValues() {
        return values();
    }

    @Override
    public String toString() {
        return code + ". " + command;
    }

    @Override
    public Screen getValue(String input) {
        return Arrays.stream(values())
            .filter(screen -> screen.code.equals(input))
            .findFirst()
            .orElseThrow(() -> {
                throw new IllegalArgumentException("[ERROR] 지원하지 않는 기능입니다.");
            });
    }

    @Override
    public String getTitle() {
        return SCREEN_TITLE;
    }
}
