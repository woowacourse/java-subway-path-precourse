package subway.domain.section.model;

public class RunTime {
    private static final int STANDARD_NEGATIVE_NUMBER = 0;

    private final int runTime;

    public RunTime(int runTime) {
        validateRunTime(runTime);
        this.runTime = runTime;
    }

    private void validateRunTime(int runTime) {
        if (runTime <= STANDARD_NEGATIVE_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 소요 시간은 양의 정수만 가능합니다.");
        }
    }
}
