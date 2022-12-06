package subway.domain.util;

public class MessageFactory {
    private static final String ERROR_FORMAT = "[ERROR] %s";
    private static final String INFO_FORMAT = "[INFO] %s \n";
    private static final String INFO_DISTANCE_FORMAT = "[INFO] 총 거리: %skm \n";
    private static final String INFO_TIME_FORMAT = "[INFO] 총 거리: %s분 \n";

    public String makeErrorMessage(ErrorCode errorCode) {
        return String.format(ERROR_FORMAT, errorCode.getMessage());
    }

    public String makeInfoMessage(InfoCode infoCode) {
        return String.format(INFO_FORMAT, infoCode.getMessage());
    }

    public String makeInfo(String str) {
        return String.format(INFO_FORMAT, str);
    }

    public String makeDistanceInfo(String str) {
        return String.format(INFO_DISTANCE_FORMAT, str);
    }

    public String makeTimeInfo(String str) {
        return String.format(INFO_TIME_FORMAT, str);
    }

}
