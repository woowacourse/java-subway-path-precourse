package subway.screen;

import java.util.Objects;
import java.util.Stack;

public class ScreenManager {
    private static final String DONE = "-1";
    private static Stack<ScreenModel> screens = new Stack<>();


    public static boolean isEmpty() {
        if(screens.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void show(ScreenModel screen) {
        String result = screen.showScreen();
        if (result == DONE) {
            return;
        }
        // todo 유효한 입력인지 검증한다.

        addNextMenuScreen(screen.getNextScreen(result));

    }

    public static void addNextMenuScreen(ScreenModel nextScreen) {
        if (Objects.isNull(nextScreen)) {
            return;
        }
        screens.push(nextScreen);
    }

    public static ScreenModel pop() {
        return screens.pop();
    }
}
