package subway.domain;

public class Section {
    private final Station firstStation;
    private final Station secondStation;

    public Section(Station firstStation, Station secondStation) {
        this.firstStation = firstStation;
        this.secondStation = secondStation;
    }

    public Station getFirstStation() {
        return firstStation;
    }

    public Station getSecondStation() {
        return secondStation;
    }

    @Override
    public boolean equals(Object object) {
        if (getClass() != object.getClass()) {
            return false;
        }
        boolean isEqualObject = false;
        Section section = (Section) object;
        if (firstStation.getName().equals(section.firstStation.getName())
            && secondStation.getName().equals(section.secondStation.getName())) {
            isEqualObject = true;
        }
        return isEqualObject;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        hashCode = prime * hashCode + firstStation.getName().hashCode()
            + secondStation.getName().hashCode();
        return hashCode;
    }
}
