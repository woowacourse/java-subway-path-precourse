package subway.controller;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import subway.domain.SubwayInitializer;

public class Controller {
    private static final Deque<Screen> screenStack = new ArrayDeque<>(Arrays.asList(MainScreen.getInstance()));
    
    public static void run() {
        SubwayInitializer.initialize();
        while (!screenStack.isEmpty()) {
            screenStack.peekLast().run();
        }
    }
    
    public static void addScreen(Screen screen) {
        screenStack.addLast(screen);
    }
    
    public static void popScreen() {
        screenStack.pollLast();
    }
}
