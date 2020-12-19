package subway;

import subway.domain.MainScreen;
import subway.domain.ScreenManager;
import subway.domain.ScreenModel;

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
