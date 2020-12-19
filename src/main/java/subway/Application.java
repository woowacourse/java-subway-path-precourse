package subway;

import subway.domain.SubwayApp;
import subway.view.InputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        new InputView(scanner);
        new SubwayApp().run();
    }
}
