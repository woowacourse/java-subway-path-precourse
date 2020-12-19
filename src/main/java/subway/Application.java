package subway;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Router router = new Router(scanner);
        InitialData.load();
        router.run();
    }
}
