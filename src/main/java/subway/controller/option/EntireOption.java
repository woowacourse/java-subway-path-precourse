package subway.controller.option;

import java.util.Scanner;
import subway.controller.PathManager;
import subway.controller.constants.QuestionNumber;

public enum EntireOption {
    PATH(QuestionNumber.ONE.getOption()) {
        @Override
        public void processSector(Scanner scanner) {
            PathManager pathManager = new PathManager(scanner);
            pathManager.processSet();
        }
    },
    TERMINATE(QuestionNumber.TERMINATE.getOption()) {
        @Override
        public void processSector(Scanner scanner) {
        }
    };

    private String option;

    private EntireOption(String option) {
        this.option = option;
    }

    abstract public void processSector(Scanner scanner);

    public String getOption() {
        return option;
    }
}
