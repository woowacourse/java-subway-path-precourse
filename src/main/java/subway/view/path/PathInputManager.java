package subway.view.path;

import java.util.Scanner;
import subway.common.ErrorCustomException;
import subway.domain.StationRepository;

public class PathInputManager {
    private static final String NOT_ENROLLED_STATION = "역이 등록되어 있지 않습니다.";
    private static final String SAME_DEPARTURE_ARRIVAL = "출발역과 도착역은 같을 수 없습니다.";
    private final Scanner scanner;

    public PathInputManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] inputStations() {
        String[] lines = new String[2];
        lines[0] = getDepartureStation();
        lines[1] = getArrivalStation(lines[0]);
        return lines;
    }

    private String getDepartureStation() {
        PathOutputManager.printDepartureStationGuide();
        String station = scanner.nextLine().trim();
        checkListDepartureStation(station);
        return station;
    }

    private void checkListDepartureStation(String station) {
        checkEnrolledStation(station);

    }

    private void checkEnrolledStation(String station) {
        if (!StationRepository.containsStation(station)) {
            throw new ErrorCustomException(NOT_ENROLLED_STATION);
        }
    }

    private String getArrivalStation(String departureStation) {
        PathOutputManager.printArrivalStationGuide();
        String station = scanner.nextLine().trim();
        checkListArrivalStation(departureStation, station);
        return station;
    }

    private void checkListArrivalStation(String departureStation, String station) {
        checkEnrolledStation(station);
        checkSameAsDepartureStation(departureStation, station);
    }

    private void checkSameAsDepartureStation(String departureStation, String station) {
        if (station.equals(departureStation)) {
            throw new ErrorCustomException(SAME_DEPARTURE_ARRIVAL);
        }
    }

}
