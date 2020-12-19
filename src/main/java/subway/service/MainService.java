package subway.service;

import subway.domain.FunctionChoice;
import subway.exception.InvalidInputException;

public class MainService {

    public void validate(String selectedFunction) throws InvalidInputException {
        FunctionChoice.validate(selectedFunction);
    }
}
