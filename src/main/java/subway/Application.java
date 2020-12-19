package subway;

import java.util.Scanner;
import subway.console.Input;
import subway.console.MainScreen;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        new Input(scanner);
        MainScreen.startProcess();
    }
}
