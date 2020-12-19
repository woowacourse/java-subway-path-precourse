package subway;

import java.util.Scanner;

import subway.controller.Subway;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        InitUtils.init();
        Subway subway = new Subway(scanner);
        subway.run();
    }
}
