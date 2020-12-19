package subway;

public class Status {
    private enum Condition {
        CONTINUE, TERMINATE;
    }

    private static Condition condition = Condition.CONTINUE;

    public static boolean isContinue() {
        return condition.equals(Condition.CONTINUE);
    }

    public static void terminate() {
        condition = Condition.TERMINATE;
    }
}
