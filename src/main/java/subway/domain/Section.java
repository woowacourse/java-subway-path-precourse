package subway.domain;

public class Section {

    private final Station source;
    private final Station target;
    private final Integer distanceWeight;
    private final Integer timeWeight;

    public Section(Station source, Station target, Integer distanceWeight, Integer timeWeight) {
        this.source = source;
        this.target = target;
        this.distanceWeight = distanceWeight;
        this.timeWeight = timeWeight;
    }

    public static Section from(String sourceName, String targetName,Integer distanceWeight, Integer timeWeight) {
        return new Section(StationRepository.findByName(sourceName),
                StationRepository.findByName(targetName), distanceWeight, timeWeight);
    }

    public Station getSource() {
        return source;
    }

    public Station getTarget() {
        return target;
    }

    public Integer getDistanceWeight() {
        return distanceWeight;
    }

    public Integer getTimeWeight() {
        return timeWeight;
    }
}
