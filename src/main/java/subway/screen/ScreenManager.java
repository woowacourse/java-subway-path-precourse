package subway.screen;

import java.util.Objects;
import java.util.Stack;

public class ScreenManager {
    private static Stack<ScreenModel> screens = new Stack<>();

    public static boolean isEmpty() {
        if (screens.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void show(ScreenModel screen) {
        String result = screen.showScreen();
        if (result == ScreenModel.GO_BACK) {
            return;
        }
        // todo 유효한 입력인지 검증한다.

        addNextMenuScreen(screen.getNextScreen(result));

    }

    public static void addNextMenuScreen(ScreenModel nextScreen) {
        if (!Objects.isNull(nextScreen)) {
            screens.push(nextScreen);
        }
    }

    public static ScreenModel pop() {
        return screens.pop();
    }
}
