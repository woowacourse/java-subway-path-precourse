package subway.enums;

import java.util.Arrays;
import java.util.List;

public enum TimeToStation {
    LINE_2(Arrays.asList(3, 3)),
    LINE_3(Arrays.asList(2, 5, 1)),
    LINE_SINBUNDANG(Arrays.asList(8, 3));

    private List<Integer> times;

    TimeToStation(List<Integer> times) {
        this.times = times;
    }

    public List<Integer> getTimes() {
        return times;
    }
}
