package subway;

import java.util.Scanner;

import subway.controller.SubwayPathController;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        SubwayPathController subwayPathController = new SubwayPathController(scanner);
        subwayPathController.run();
        scanner.close();
    }
}
