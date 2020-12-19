package subway.type;

public enum IndexType {
    UP(0),
    DOWN(1);

    private final int index;

    IndexType(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
