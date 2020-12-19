package subway.service.validation;

import subway.exception.path.PathException;
import subway.exception.path.SameFromToStationException;
import subway.exception.path.TwoStationIsNotConnectedException;
import subway.service.PathService;

public class PathValidation {

    public static boolean checkGetShortestPath(String fromStationName, String toStationName) {
        try {
            if (fromStationName.equals(toStationName)) {
                throw new SameFromToStationException();
            }

            if (!PathService.isFromToStationConnected(fromStationName, toStationName)) {
                throw new TwoStationIsNotConnectedException();
            }

            return true;
        } catch (PathException e) {
            e.printError();
            return false;
        }

    }

}
