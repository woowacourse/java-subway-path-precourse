package subway.exception.path;

import subway.exception.CustomException;

public abstract class PathException extends CustomException {

    private final String HEADER = "경로 오류 - ";

    public String getHeader() {
        return HEADER;
    }

    abstract public void printError();
}
