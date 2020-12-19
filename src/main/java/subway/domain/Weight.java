package subway.domain;

import java.util.Objects;

public class Weight {
    private final int km;
    private final int minute;

    public Weight(int km, int minute) {
        this.km = km;
        this.minute = minute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weight weight = (Weight) o;
        return km == weight.km &&
                minute == weight.minute;
    }

    @Override
    public int hashCode() {
        return Objects.hash(km, minute);
    }
}
