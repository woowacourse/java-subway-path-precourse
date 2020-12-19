package subway.Controller;

import subway.Controller.exceptions.SameStationPathRequestException;
import subway.domain.DistanceGraph;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.TimeGraph;
import subway.dto.PathDTO;
import subway.view.InputView;
import subway.view.OutputView;

public class InquiryController {

    public static void inquiryByTime() {
        Station departureStation = StationRepository.searchByName(InputView.getDepartureStationName());
        Station arrivalStation = StationRepository.searchByName(InputView.getArrivalStationName());

        if (departureStation.equals(arrivalStation)) {
            throw new SameStationPathRequestException();
        }
        PathDTO pathDTO = TimeGraph.getShortestPath(departureStation, arrivalStation);

        OutputView.printResult(pathDTO);
    }

    public static void inquiryByDistance() {
        Station departureStation = StationRepository.searchByName(InputView.getDepartureStationName());
        Station arrivalStation = StationRepository.searchByName(InputView.getArrivalStationName());

        if (departureStation.equals(arrivalStation)) {
            throw new SameStationPathRequestException();
        }
        PathDTO pathDTO = DistanceGraph.getShortestPath(departureStation, arrivalStation);

        OutputView.printResult(pathDTO);
    }
}
