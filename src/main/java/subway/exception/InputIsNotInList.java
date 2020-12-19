package subway.exception;

import subway.util.PrintUtils;

public class InputIsNotInList extends CommandException{

    @Override
    public void printError() {
        PrintUtils.printError(super.getHeader() + "실행할 수 있는 기능이 아닙니다.");
    }
}
