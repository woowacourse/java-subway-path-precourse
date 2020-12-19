package subway.view;

import subway.MainType;
import subway.WeightType;
import subway.domain.StationRepository;
import subway.exception.CannotFindCommandException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    private String scanLine() {
        return scanner.nextLine();
    }

    public String scanMainTypeCommand() {
        String command = scanLine().toUpperCase();
        if (Arrays.stream(MainType.values())
                .noneMatch(type -> type.getCommand().equals(command))) {
            throw new CannotFindCommandException(command);
        }
        return command;
    }

    public String scanWeithTypeCommand() {
        String command = scanLine();
        if (Arrays.stream(WeightType.values())
                .noneMatch(type -> type.getCommand().equals(command))) {
            throw new CannotFindCommandException(command);
        }
        return command;
    }

    public String scanStationName() {
        String stationName = scanLine();
        StationRepository.getStationByName(stationName);
        return stationName;
    }
}
