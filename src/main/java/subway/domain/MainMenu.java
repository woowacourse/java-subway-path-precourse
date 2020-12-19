package subway.domain;

import subway.views.OutputConstant;

public enum MainMenu {
    ROUTE_LOOKUP("1", "경로 조회"),
    EXIT_PROGRAM("Q", "종료");

    private final String option;
    private final String description;

    MainMenu(String option, String description) {
        this.option = option;
        this.description = description;
    }

    @Override
    public String toString() {
        return option + OutputConstant.OPTION_SEPARATOR + description;
    }
}
