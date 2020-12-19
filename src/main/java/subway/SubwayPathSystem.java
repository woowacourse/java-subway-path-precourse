package subway;

import java.util.Scanner;
import subway.controller.EntirePathSystem;
import subway.controller.Initiator;

public class SubwayPathSystem {
    private final Scanner scanner;

    SubwayPathSystem(Scanner scanner) {
        Initiator.initiateSet();
        this.scanner = scanner;
    }

    public void process() {
        EntirePathSystem entireSystem = new EntirePathSystem(scanner);
        entireSystem.runProgram();
    }
}
