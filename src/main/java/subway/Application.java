package subway;

import subway.util.DefaultSetting;
import subway.view.MainMenu;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        DefaultSetting.defaultSetting();
        new MainMenu(scanner).startMainMENU();
    }
}
