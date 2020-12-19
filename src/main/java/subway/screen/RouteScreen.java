package subway.screen;

import java.util.Arrays;

public enum RouteScreen implements Screen {

    DISTANCE("1", "최단 거리") {
        @Override
        public Screen run() {
            /*
             * 로직 실행 후, 메인화면으로 이동
             * */
            System.out.println("최단 거리 실행 미구현");
            return MainScreen.ROUTE;
        }
    },
    TIME("2", "최소 시간") {
        @Override
        public Screen run() {
            /*
             * 로직 실행 후, 메인화면으로 이동
             * */
            System.out.println("최소 시간 실행 미구현");
            return MainScreen.ROUTE;
        }
    };

    private final String code;
    private final String command;

    RouteScreen(String code, String command) {
        this.code = code;
        this.command = command;
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
}
