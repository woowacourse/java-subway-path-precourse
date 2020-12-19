package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import subway.domain.constants.DomainConstant;
import subway.domain.constants.DomainErrorMessage;

public class Line {
    private List<Station> stations = new ArrayList<>();
    private String name;

    public Line(String name) {
        checkEndName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void insertStation(int location, Station station) {
        checkOverlappedStation(station.getName());
        stations.add(location - DomainConstant.HUMAN_NUMBER_CALIBRATION, station);
    }

    public void deleteStation(String name) {
        stations.removeIf(station -> Objects.equals(station.getName(), name));
    }


    public boolean isContainedStation(String target) {
        long checkOverlapped = stations.stream()
                .map(Station::getName)
                .filter(station -> station.equals(target))
                .count();

        if (checkOverlapped == DomainConstant.ZERO_LONG_NUMBER) {
            return false;
        }

        return true;
    }

    private void checkOverlappedStation(String target) {
        if (isContainedStation(target)) {
            System.out.println();
            System.out.println(DomainErrorMessage.OVERLAP_STATION);
            throw new IllegalArgumentException(DomainErrorMessage.OVERLAP_STATION);
        }
    }

    private void checkEndName(String name) {
        String last = name.substring(name.length() - DomainConstant.LAST_LOCATION);

        if (!last.equals(DomainConstant.LINE_STRING)) {
            System.out.println();
            System.out.println(DomainErrorMessage.LINE_FORMAT);
            throw new IllegalArgumentException(DomainErrorMessage.LINE_FORMAT);
        }
    }
}
