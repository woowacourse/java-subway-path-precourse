package subway.service.validation;

import subway.exception.CustomException;
import subway.exception.path.PathException;
import subway.exception.path.SameFromToStationException;
import subway.exception.path.TwoStationIsNotConnectedException;
import subway.exception.station.StationIsNotExistException;
import subway.service.PathService;
import subway.service.StationService;

public class PathValidation {

    public static boolean checkGetShortestPath(String fromStationName, String toStationName) {
        try {
            if (fromStationName.equals(toStationName)) {
                throw new SameFromToStationException();
            }

            if(!StationService.isAlreadyExistStation(fromStationName)) {
                throw new StationIsNotExistException();
            }

            if(!StationService.isAlreadyExistStation(toStationName)) {
                throw new StationIsNotExistException();
            }

            if (!PathService.isFromToStationConnected(fromStationName, toStationName)) {
                throw new TwoStationIsNotConnectedException();
            }

            return true;
        } catch (CustomException e) {
            e.printError();
            return false;
        }

    }

}
