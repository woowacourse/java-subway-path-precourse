package subway;

import java.util.Scanner;
import subway.domain.Machine;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Machine machine = new Machine();
        machine.start(scanner);
    }
}
