package subway;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Input.init(scanner);
        DataInitService.init();
        UserInterfaceView userInterfaceView = new UserInterfaceView();
        userInterfaceView.start();
    }
}
