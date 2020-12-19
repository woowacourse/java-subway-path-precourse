package subway.domain.Section;

public class ResultDto {

    private Time resultTime;
    private Distance resultDistance;

    private ResultDto(Time resultTime, Distance resultDistance) {
        this.resultTime = resultTime;
        this.resultDistance = resultDistance;
    }

    public static ResultDto create(Time resultTime, Distance resultDistance) {
        return new ResultDto(resultTime, resultDistance);
    }

    public Time getResultTime() {
        return resultTime;
    }

    public void setResultTime(Time resultTime) {
        this.resultTime = resultTime;
    }

    public Distance getResultDistance() {
        return resultDistance;
    }

    public void setResultDistance(Distance resultDistance) {
        this.resultDistance = resultDistance;
    }
}
