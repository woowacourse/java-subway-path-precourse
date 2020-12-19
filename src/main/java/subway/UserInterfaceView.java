package subway;

import java.util.Scanner;

public class UserInterfaceView {

    private static Scanner scanner;

    public UserInterfaceView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            if (printMainViewAndReturnIsEnd()) {
                break;
            }
        }
    }

    private boolean printMainViewAndReturnIsEnd() {
        OutPut.printMainView();
        return false;
    }


}
