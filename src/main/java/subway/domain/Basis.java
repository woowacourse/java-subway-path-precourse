package subway.domain;

import subway.exception.InvalidInputException;
import subway.repository.StationRepository;

public class Basis {

    private String basis;
    private Station srcStation;
    private Station dstStation;

    public Basis(String basis, String srcStationName, String dstStationName) throws InvalidInputException {
        this.basis = basis;
        this.srcStation = new Station(srcStationName);
        this.dstStation = new Station(dstStationName);
    }

    public String getBasis() {
        return basis;
    }

    public Station getSrcStation() {
        return srcStation;
    }

    public Station getDstStation() {
        return dstStation;
    }


    public void validate() throws InvalidInputException {
        BasisChoice.validate(this.basis);
        validateStations();
    }

    private void validateStations() {
        validateSrcAndDstDifferent();
        validateStationsExist();
    }

    private void validateSrcAndDstDifferent() throws InvalidInputException {
        if (srcStation.equals(dstStation))
            throw new InvalidInputException(InvalidInputException.ExceptionCode.SAME_SRC_AND_DST);
    }

    private void validateStationsExist() throws InvalidInputException {
        validateSrcStation();
        validateDstStation();
    }

    private void validateSrcStation() throws InvalidInputException {
        if (!StationRepository.stations().contains(srcStation))
            throw new InvalidInputException(InvalidInputException.ExceptionCode.NO_SUCH_STATION);
    }

    private void validateDstStation() throws InvalidInputException {
        if (!StationRepository.stations().contains(dstStation))
            throw new InvalidInputException(InvalidInputException.ExceptionCode.NO_SUCH_STATION);
    }
}
