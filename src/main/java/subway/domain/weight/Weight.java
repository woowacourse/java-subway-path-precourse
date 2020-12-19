package subway.domain.weight;

import java.util.HashMap;
import java.util.Map;

public class Weight {
    private final Map<WeightType, Double> weightValues = new HashMap<>();

    public Weight(double distance, double time) {
        this.weightValues.put(WeightType.DISTANCE, distance);
        this.weightValues.put(WeightType.TIME, time);
    }

    public double get(WeightType type) {
        return weightValues.get(type);
    }
}
