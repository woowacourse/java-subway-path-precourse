package subway.domain.function;

import java.util.Arrays;
import java.util.Scanner;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.view.InputView;

public enum FindRouteFunction {
    FIND_SHORTEST_ROUTE("1") {
        @Override
        public void operate(Scanner scanner) {
            Station startStation = getInputStartStation(scanner);
            Station endStation = getInputEndStation(scanner);
            validateOverlappedStation(startStation, endStation);
        }
    },
    FIND_MINIMUM_TIME_ROUTE("2") {
        @Override
        public void operate(Scanner scanner) {
        }
    },
    BACK("B") {
        @Override
        public void operate(Scanner scanner) {
        }
    };

    private String number;

    FindRouteFunction(String number) {
        this.number = number;
    }

    public static FindRouteFunction getFindRouteFunctionByNumber(String inputNumber) {
        return Arrays.stream(FindRouteFunction.values())
            .filter(function -> function.number.equals(inputNumber))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다."));
    }

    private static Station getInputStartStation(Scanner scanner) {
        String input = InputView.inputStartStation(scanner);
        Station station = new Station(input);
        validateIfStationExists(station);
        return station;
    }

    private static Station getInputEndStation(Scanner scanner) {
        String input = InputView.inputEndStation(scanner);
        Station station = new Station(input);
        validateIfStationExists(station);
        return station;
    }

    private static void validateIfStationExists(Station station) {
        if (!StationRepository.contains(station)) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 역입니다.");
        }
    }

    private static void validateOverlappedStation(Station startStation, Station endStation) {
        if (startStation.equals(endStation)) {
            throw new IllegalArgumentException("[ERROR] 출발역과 도착역이 같으면 안 됩니다.");
        }
    }

    public abstract void operate(Scanner scanner);
}
