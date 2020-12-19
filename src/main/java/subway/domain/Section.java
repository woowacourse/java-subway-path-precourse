package subway.domain;

public class Section {
    private final Station firstStation;
    private final Station secondStation;

    public Section(Station firstStation, Station secondStation) {
        this.firstStation = firstStation;
        this.secondStation = secondStation;
    }
}
