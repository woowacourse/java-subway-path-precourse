package subway;

import subway.screen.MainScreen;
import subway.screen.ScreenManager;
import subway.screen.ScreenModel;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        ScreenManager.addNextMenuScreen(new MainScreen(scanner));

        while(!ScreenManager.isEmpty()) {
            ScreenModel nextScreen = ScreenManager.pop();
            ScreenManager.show(nextScreen);
            nextScreen.apply();
        }
    }
}
