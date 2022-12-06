package subway.domain.util;

public class MessageFactory {
    private static final String ERROR_FORMAT = "[ERROR] %s";
    private static final String INFO_FORMAT = "[INFO] %s \n";

    public String makeErrorMessage(ErrorCode errorCode) {
        return String.format(ERROR_FORMAT, errorCode.getMessage());
    }

    public String makeInfoMessage(InfoCode infoCode) {
        return String.format(INFO_FORMAT, infoCode.getMessage());
    }

    public String makeInfo(String str) {
        return String.format(INFO_FORMAT, str);
    }
}
