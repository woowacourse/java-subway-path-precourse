package subway.domain.distanceTime;

import subway.exception.DistanceTimeException;
import subway.exception.ErrorCode;

public class Distance {
    private int km;

    public Distance(int km) {
        this.km = km;
        validate(km);
    }

    private void validate(int km) {
        if (km < 1) {
            throw new DistanceTimeException(ErrorCode.INPUT_VALUE_MUST_NATURAL);
        }
    }

    public int getKm() {
        return km;
    }
}
