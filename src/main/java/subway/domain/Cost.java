package subway.domain;

public class Cost {

    int distanceCost;
    int timeCost;

    public Cost(int distanceCost, int timeCost) {
        this.distanceCost = distanceCost;
        this.timeCost = timeCost;
    }

    public int getDistanceCost() {
        return this.distanceCost;
    }

    public int getTimeCost() {
        return this.timeCost;
    }

    @Override
    public String toString() {
        return this.timeCost + " " + this.distanceCost;
    }

    public void addTimeCost(int timeCost) {
        this.timeCost += timeCost;
    }

    public void addDistanceCost(int distanceCost) {
        this.distanceCost += distanceCost;
    }
}
