package subway.domain;

public class Section {
    Station from;
    Station to;
    int distance;
    int takenTime;

    public Section(Station from, Station to, int distance, int takenTime) {
        this.from = from;
        this.to = to;
        this.distance = distance;
        this.takenTime = takenTime;
    }

    public Station from() {
        return from;
    }

    public Station to() {
        return to;
    }

    public int getDistance() {
        return distance;
    }

    public int getTakenTime() {
        return takenTime;
    }
}
