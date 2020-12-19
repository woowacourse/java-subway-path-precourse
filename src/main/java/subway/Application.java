package subway;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        UserInterfaceView userInterfaceView = new UserInterfaceView(scanner);
        userInterfaceView.start();
    }
}
