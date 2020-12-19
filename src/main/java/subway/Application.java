package subway;

import subway.domain.MainScreen;
import subway.domain.ScreenManager;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        ScreenManager.add(new MainScreen());

        while(!ScreenManager.isEmpty()) {
            ScreenManager.show(ScreenManager.pop());
        }
    }
}
