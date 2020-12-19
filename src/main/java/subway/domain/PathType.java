package subway.domain;

public enum PathType {
    DISTANCE(1), TIME(2);

    private int number;

    PathType(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
