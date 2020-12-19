package subway;

import java.util.Scanner;

public class UserInterfaceView {

    private static Scanner scanner;

    public UserInterfaceView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            if (printViewAndReturnIsEnd()) {
                break;
            }
        }
    }

    private boolean printViewAndReturnIsEnd() {
        // TODO - 기능구현
        return false;
    }
}
