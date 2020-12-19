package subway.exception;

import subway.domain.Section.Section;

public class AlreadyExistSectionException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "[ERROR] %s역과 %s을 잇는 구간은 이미 존재합니다.";

    public AlreadyExistSectionException(Section section) {
        super(String.format(ERROR_MESSAGE, section.getPreStation(), section.getNextStation()));
    }
}
