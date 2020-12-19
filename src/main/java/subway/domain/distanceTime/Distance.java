package subway.domain.distanceTime;

import java.math.BigDecimal;

public class Distance {
    private BigDecimal km;

    public Distance(BigDecimal km) {
        this.km = km;
    }

    public static Distance km(double km) {
        return new Distance(BigDecimal.valueOf(km));
    }
}
