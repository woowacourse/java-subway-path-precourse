package subway.domain;

import subway.repository.StationRepository;

/**
 * @author yhh1056
 * @since 2020/12/19
 */
public class Section {
    private Station station;
    private Station nextStation;
    private Street street;
    private Time time;

    public Section(String startStationName, String finishStationName, Street street, Time time) {
        this.station = StationRepository.findByName(startStationName);
        this.nextStation = StationRepository.findByName(finishStationName);
        this.street = street;
        this.time = time;
    }

    public String getStationName() {
        return station.getName();
    }

    public String getNextStationName() {
        return nextStation.getName();
    }

    public int getStreet() {
        return street.getStreet();
    }
}
