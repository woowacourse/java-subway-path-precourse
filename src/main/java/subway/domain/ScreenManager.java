package subway.domain;

import java.util.Stack;

public class ScreenManager {
    private static Stack<ScreenModel> screens = new Stack<>();



    public static boolean isEmpty() {
        if(screens.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void show(ScreenModel screen) {
        screen.showMenu();
    }

    public static void add(ScreenModel screen) {
        screens.push(screen);
    }

    public static ScreenModel pop() {
        return screens.pop();
    }
}
