package subway.domain.selector;

import java.util.List;
import subway.domain.Station.Station;
import subway.domain.Station.StationRepository;
import subway.domain.subwaymap.SubwayMap;
import subway.domain.subwaymap.SubwayMapRepository;
import subway.view.InputView;
import subway.view.MessageView;
import subway.view.OutputView;

public class ShortestPathFindItem extends Selector implements Manipulable {

    public ShortestPathFindItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void execute(String subwayMapName) {
        MessageView.printDepartureInputMessage();
        String departureStationName = InputView.getStationName();
        Station departureStation = StationRepository.getStationByName(departureStationName);

        MessageView.printArrivalInputMessage();
        String arrivalStationName = InputView.getStationName();
        Station arrivalStation = StationRepository.getStationByName(arrivalStationName);

        SubwayMap subwayMap = SubwayMapRepository.subwayMaps().get(subwayMapName);
        List<Station> shortestPath = subwayMap.findShortestPathListByDistance(departureStation, arrivalStation);
        double shortestPathDistance = subwayMap.findShortestPathDistance(departureStation, arrivalStation);
        double travelTime = subwayMap.findStationPathTravelTime(shortestPath);

        OutputView.printDistance(shortestPathDistance);
        OutputView.printTravelTime(travelTime);
        OutputView.printStations(shortestPath);
    }

}
