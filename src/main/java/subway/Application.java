package subway;

import subway.view.screen.MainScreen;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        executeSystem(scanner);
    }

    private static void executeSystem(Scanner scanner) {
        String function = MainScreen.getFunction(scanner);
    }
}
