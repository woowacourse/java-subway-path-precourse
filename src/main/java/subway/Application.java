package subway;

import java.util.Scanner;

import subway.controller.SubwayControlelr;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현

        SubwayControlelr subwayControlelr = new SubwayControlelr(scanner);
        subwayControlelr.run();
    }
}
