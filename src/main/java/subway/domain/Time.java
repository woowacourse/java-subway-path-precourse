package subway.domain;

public class Time {

    private final int minute;

    private Time(int minute){
        this.minute = minute;
    }

    public static Time newTime(int minute) {
        return new Time(minute);
    }

    public int getMinute() {
        return minute;
    }
}
