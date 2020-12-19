package subway;

import subway.Controller.MainController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        new MainController(scanner);
    }

}
