package subway;

import subway.domain.*;
import subway.view.Input;
import subway.view.Output;

import java.util.List;
import java.util.Scanner;

public class Controller {
    private static final List<Station> stations = StationRepository.stations();
    private Output output;
    private Input input;

    public Controller(Scanner scanner) {
        output = new Output();
        input = new Input(scanner);
    }

    public void run() {
        while (true) {
            output.printMainFunction();
            String command = input.getMainFunction();
            if (command.equals(Constant.COMMAND_QUIT)) {
                break;
            }
            if (command.equals(Constant.COMMAND_ONE)) {
                runCommand();
                continue;
            }
            throw new IllegalArgumentException(String.join(" ", Constant.PREFIX_ERROR, "존재하지 않는 기능입니다."));
        }
    }

    private void runCommand() {
        output.printPathStandard();
        String command = input.getMainFunction();
        if (command.equals(Constant.COMMAND_BACK)) {
            return;
        }
        if (command.equals(Constant.COMMAND_ONE) || command.equals(Constant.COMMAND_TWO)) {
            readPath(command);
            return;
        }
        throw new IllegalArgumentException(String.join(" ", Constant.PREFIX_ERROR, "존재하지 않는 기능입니다."));
    }

    private void readPath(String command) {
        Station startStation = validStation(input.getStartStation());
        Station endStation = validStation(input.getEndStation());
        isSameStation(startStation, endStation);
        Path resultPath = PathRepository.getPath(startStation, endStation, command);
        output.printPathResult(resultPath);
    }

    private Station validStation(String stationName) {
        return stations.stream().filter(s -> s.isSameName(stationName)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.join(" ", Constant.PREFIX_ERROR, "존재하지 않는 역입니다.")));
    }

    private void isSameStation(Station startStation, Station endStation) {
        if (startStation.isSameStation(endStation)) {
            throw new IllegalArgumentException(String.join(" ", Constant.PREFIX_ERROR, "출발역과 도착역이 같을 수 없습니다."));
        }
    }
}
