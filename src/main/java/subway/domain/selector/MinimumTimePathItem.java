package subway.domain.selector;

import java.util.List;
import subway.domain.Station.Station;
import subway.domain.Station.StationRepository;
import subway.domain.subwaymap.SubwayMap;
import subway.domain.subwaymap.SubwayMapRepository;
import subway.view.InputView;
import subway.view.MessageView;
import subway.view.OutputView;

public class MinimumTimePathItem extends Selector implements Manipulable {

    private Station departureStation;
    private Station arrivalStation;
    private static SelectorValidator selectorValidator = new SelectorValidator();

    public MinimumTimePathItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void execute(String subwayMapName) {
        initStations();

        SubwayMap subwayMap = SubwayMapRepository.subwayMaps().get(subwayMapName);
        List<Station> shortestPath = subwayMap.findShortestPathListByTime(departureStation, arrivalStation);
        double shortestPathTravelTime = subwayMap.findShortestPathTime(departureStation, arrivalStation);
        double totalDistance = subwayMap.findStationPathTravelDistance(shortestPath);

        OutputView.printDistance(totalDistance);
        OutputView.printTravelTime(shortestPathTravelTime);
        OutputView.printStations(shortestPath);
    }

    private void initStations() {
        MessageView.printDepartureInputMessage();
        String departureStationName = InputView.getStationName();
        departureStation = StationRepository.getStationByName(departureStationName);
        selectorValidator.validateContains(departureStation);

        MessageView.printArrivalInputMessage();
        String arrivalStationName = InputView.getStationName();
        arrivalStation = StationRepository.getStationByName(arrivalStationName);
        selectorValidator.validateContains(arrivalStation);

        selectorValidator.validateEqualName(departureStationName, arrivalStationName);
    }

}
