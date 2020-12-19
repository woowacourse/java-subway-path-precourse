package subway.screen;

import java.util.Arrays;

public enum MainScreen implements Screen {

    ROUTE("1", "경로 조회") {
        @Override
        public Screen run() {
            /*
             * 아무것도 안하고 RouteScreen을 반환한다.
             * */
            return RouteScreen.DISTANCE;
        }
    },
    EXIT("Q", "종료") {
        @Override
        public Screen run() {
            //아무것도 하지 않고 null을 반환
            return null;
        }
    };

    private static final String SCREEN_TITLE = "메인 화면";

    private final String code;
    private final String command;

    MainScreen(String code, String command) {
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
