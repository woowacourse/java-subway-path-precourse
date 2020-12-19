package subway;

public enum StatusType {
    ON(true),
    OFF(false);

    private boolean value;

    StatusType(boolean value) {
        this.value = value;
    }

    public static StatusType condition = StatusType.ON;

    public StatusType getCondition() {
        return condition;
    }

    public static void finishSubwayPath() {
        condition = StatusType.OFF;
    }

    public static boolean isContinue() {
        return condition.value;
    }
}
