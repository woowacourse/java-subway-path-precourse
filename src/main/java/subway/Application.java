package subway;

import subway.view.InputView;
import subway.view.screen.MainScreen;
import subway.view.screen.ScreenManager;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        SubwayPathPrecourse.start(new InputView(scanner));
    }
}
